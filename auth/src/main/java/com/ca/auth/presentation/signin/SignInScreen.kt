package com.ca.auth.presentation.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.ca.core.presentation.components.textfields.OutlinedTextField
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme
import com.google.accompanist.insets.imePadding

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    viewModel: SignInViewModel
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        ConstraintLayout(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
        ) {
            val (column, signInButton, signInHeadline) = createRefs()

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp),
            ) {
                Text(
                    text = "Sign In",
                    modifier = Modifier,
                    style = Theme.typography.headerMiddle
                )

                PhoneTextField(
                    value = viewModel.phoneNumber,
                    modifier = Modifier,
                    errorMessage = uiState.phoneNumberError
                )

                PasswordTextField(
                    value = viewModel.password,
                    modifier = Modifier,
                    errorMessage = uiState.passwordError
                )
            }
        }
    }
}

@Composable
fun PhoneTextField(
    value: MutableState<String>,
    modifier: Modifier,
    errorMessage: String?
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        label = "",
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Phone,
        visualTransformation = VisualTransformation.None,
        leadingIcon = {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp),
                text = "+380",
                style = Theme.typography.bodyLarge,
                color = Theme.colors.onSurface
            )
        }
    )
}

@Composable
fun PasswordTextField(
    value: MutableState<String>,
    modifier: Modifier,
    errorMessage: String?
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        label = "",
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    )
}



