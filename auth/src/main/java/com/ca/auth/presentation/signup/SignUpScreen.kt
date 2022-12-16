package com.ca.auth.presentation.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.ca.auth.presentation.components.PasswordTextField
import com.ca.auth.presentation.components.PhoneTextField
import com.ca.core.presentation.components.buttons.RoundedTextButton
import com.ca.core.presentation.components.textfields.OutlinedTextField
import com.ca.core.presentation.theme.Theme
import com.google.accompanist.insets.imePadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignUpScreen(
    viewModel: SignUpViewModelImpl = koinViewModel(),
    onSignUpClick: (String) -> Unit
) {

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Surface(
            color = Theme.colors.background
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .imePadding(),
                contentPadding = PaddingValues(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                item {
                    Text(
                        text = "Sign Up",
                        modifier = Modifier,
                        style = Theme.typography.headerMiddle,
                        color = Theme.colors.onBackground
                    )
                }

                item {
                    EmailTextField(
                        value = viewModel.email,
                        modifier = Modifier
                            .fillMaxSize(),
                        errorMessage = uiState.phoneNumberError
                    )
                }

                item {
                    PhoneTextField(
                        value = viewModel.phoneNumber,
                        modifier = Modifier,
                        errorMessage = uiState.phoneNumberError
                    )
                }

                item {
                    NameTextField(
                        value = viewModel.name,
                        modifier = Modifier,
                        errorMessage = uiState.phoneNumberError
                    )
                }

                item {
                    PasswordTextField(
                        value = viewModel.password,
                        modifier = Modifier,
                        errorMessage = uiState.passwordError
                    )
                }

                item {
                    RoundedTextButton(
                        text = "Sign Up",
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxSize(),
                        enabled = true
                    ) {
                        onSignUpClick(viewModel.phoneNumber.value)
                    }
                }
            }
        }
    }
}

@Composable
fun EmailTextField(
    value: MutableState<String>,
    modifier: Modifier,
    errorMessage: String?
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        label = "Email",
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Email,
        visualTransformation = VisualTransformation.None,
    )
}

@Composable
fun NameTextField(
    value: MutableState<String>,
    modifier: Modifier,
    errorMessage: String?
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        label = "Name",
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Text,
        visualTransformation = VisualTransformation.None,
    )
}