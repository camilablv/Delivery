package com.ca.delivery.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ca.auth.presentation.AuthActivity
import com.ca.auth.presentation.signin.SignInScreen
import com.ca.auth.presentation.signup.SignUpScreen
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme
import com.ca.auth.presentation.navigation.Routes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val intent = Intent(this, AuthActivity::class.java)
        startActivity(intent)

        setContent {
            DeliveryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Theme.colors.background
                ) {

                }
            }
        }
    }
}
