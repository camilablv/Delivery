package com.ca.auth.presentation

import android.app.Activity
import android.content.Intent
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
import com.ca.auth.presentation.signup.SignUpViewModelImpl
import com.ca.auth.presentation.signup.VerifyCodeScreen
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme
import com.google.firebase.auth.PhoneAuthOptions
import org.koin.androidx.viewmodel.ext.android.viewModel
import java.util.concurrent.TimeUnit

class AuthActivity : ComponentActivity() {

    private val authViewModel: SignUpViewModelImpl by viewModel()

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

//    @Composable
//    fun AuthNavigation(
//        navHostController: NavHostController,
//        onVerificationCompleted: () -> Unit
//    ) {
//        composable(Routes.SignIn.route) {
//            SignInScreen(
//                onSignUpClick = {
//                    navHostController.navigate(Routes.SignUp.route)
//                }
//            )
//        }
//
//        composable(Routes.SignUp.route) {
//            SignUpScreen(
//                viewModel = authViewModel,
//                onVerifyClick = { phoneNumber ->
//                    val options = PhoneAuthOptions.newBuilder(authViewModel.firebaseAuth)
//                        .setPhoneNumber(phoneNumber)
//                        .setTimeout(60L, TimeUnit.SECONDS)
//                        .setActivity(this)
//                        .setCallbacks(authViewModel.callbacks)
//                        .build()
//                    authViewModel.firebaseAuth
//                        .verifyPhoneNumber(options)
//                    navHostController.navigate(Routes.VerifyCode.route)
//                }
//            )
//        }
//
//        composable(Routes.VerifyCode.route) {
//            VerifyCodeScreen(
//                viewModel = authViewModel,
//                onVerifyClick = { code ->
//                    authViewModel.verifyCode(code)
//                },
//                onVerificationCompleted = onVerificationCompleted
//            )
//        }
//    }

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
                SignUpScreen(
                    authViewModel,
                    onSignUpClick = { phoneNumber ->
                        PhoneAuthOptions
                            .newBuilder()
                            .setPhoneNumber(phoneNumber)
                            .setTimeout(60L, TimeUnit.SECONDS)
                            .setActivity(this@AuthActivity)
                            .setCallbacks(authViewModel.callbacks)
                            .build()
                            .let { authViewModel.verifyPhoneNumber(it) }
                    },
                    navigateToCodeScreen = {
                        navHostController.navigate(Routes.VERIFY_CODE.route)
                    }
                )
            }
            composable(Routes.VERIFY_CODE.route) {
                VerifyCodeScreen(
                    viewModel = authViewModel,
                    onVerifyClick = { code ->
                        authViewModel.signIn(code)
                    },
                    onVerificationCompleted = {
                        val intent = Intent()
                        setResult(Activity.RESULT_OK, intent)
                        finish()
                    }
                )
            }
        }
    }
}