package com.ca.auth.presentation

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
import com.ca.auth.data.network.AuthProvider
import com.ca.auth.presentation.navigation.Routes
import com.ca.auth.presentation.signin.SignInScreen
import com.ca.auth.presentation.signup.SignUpScreen
import com.ca.auth.presentation.signup.VerifyCodeScreen
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme
import org.koin.android.ext.android.get

class AuthActivity : ComponentActivity() {

    private val authProvider: AuthProvider = get()

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
                SignUpScreen { phoneNumber ->
                    authProvider.verify(this@AuthActivity, phoneNumber)
                    navHostController.navigate(Routes.VERIFY_CODE.route)
                }
            }
            composable(Routes.VERIFY_CODE.route) {
                VerifyCodeScreen { code ->
                    val credential = authProvider.credential(code)
                    authProvider.signIn(credential)
                }
            }
        }
    }
}