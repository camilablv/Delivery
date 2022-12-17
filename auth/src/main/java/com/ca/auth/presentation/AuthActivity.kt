package com.ca.auth.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ca.auth.presentation.navigation.Routes
import com.ca.auth.presentation.signin.SignInScreen
import com.ca.auth.presentation.signup.SignUpScreen
import com.ca.auth.presentation.signup.VerifyCodeScreen
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.concurrent.TimeUnit

class AuthActivity : ComponentActivity() {

    val auth = FirebaseAuth.getInstance()
    lateinit var verificationId: String

    private val onVerificationStateChangedCallbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        override fun onVerificationCompleted(credential: PhoneAuthCredential) {

        }

        override fun onVerificationFailed(exception: FirebaseException) {
            TODO("Not yet implemented")
        }

        override fun onCodeSent(id: String, token: PhoneAuthProvider.ForceResendingToken) {
            verificationId = id
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            DeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Theme.colors.background
                ) {
                    NavHost(navHostController = rememberNavController())
                }
            }
        }
    }

    private fun verify(phoneNumber: String) {
        val options = PhoneAuthOptions
            .newBuilder()
            .setPhoneNumber(phoneNumber)
            .setActivity(this)
            .setTimeout(60L, TimeUnit.SECONDS)
            .setCallbacks(onVerificationStateChangedCallbacks)
            .build()

        PhoneAuthProvider.verifyPhoneNumber(options)
    }

    fun signIn(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = task.result?.user
                } else {

                }
            }
    }

    @Composable
    fun NavHost(navHostController: NavHostController) {
        androidx.navigation.compose.NavHost(
            navController = navHostController,
            startDestination = Routes.SIGNUP.route
        ) {
            composable(Routes.SIGNIN.route) {
                SignInScreen()
            }
            composable(Routes.SIGNUP.route) {
                SignUpScreen {
                    verify(it)
                    navHostController.navigate(Routes.VERIFY_CODE.route)
                }
            }
            composable(Routes.VERIFY_CODE.route) {
                VerifyCodeScreen { code ->
                    val credential = PhoneAuthProvider.getCredential(verificationId, code)
                    signIn(credential)
                }
            }
        }
    }
}