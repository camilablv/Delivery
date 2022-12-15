package com.ca.auth.presentation.signin

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
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
import androidx.constraintlayout.compose.Dimension
import com.ca.auth.presentation.components.PasswordTextField
import com.ca.auth.presentation.components.PhoneTextField
import com.ca.core.presentation.components.buttons.RoundedTextButton
import com.ca.core.presentation.components.textfields.OutlinedTextField
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme
import com.google.accompanist.insets.imePadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun SignInScreen(
    viewModel: SignInViewModelImpl = koinViewModel()
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Surface(color = Theme.colors.background) {
            ConstraintLayout(
                modifier = Modifier
                    .fillMaxSize()
                    .imePadding()
            ) {
                val (signInButton, signInHeadline, phoneTextField, passwordTextField) = createRefs()

                Text(
                    text = "Sign In",
                    modifier = Modifier
                        .constrainAs(signInHeadline) {
                            top.linkTo(parent.top, 100.dp)
                            start.linkTo(parent.start, 24.dp)
                            end.linkTo(parent.end, 24.dp)
                            width = Dimension.fillToConstraints
                        },
                    style = Theme.typography.headerMiddle,
                    color = Theme.colors.onBackground
                )

                PhoneTextField(
                    value = viewModel.phoneNumber,
                    modifier = Modifier
                        .constrainAs(phoneTextField) {
                            top.linkTo(signInHeadline.bottom, 16.dp)
                            start.linkTo(parent.start, 24.dp)
                            end.linkTo(parent.end, 24.dp)
                            width = Dimension.fillToConstraints
                        },
                    errorMessage = uiState.phoneNumberError
                )

                PasswordTextField(
                    value = viewModel.password,
                    modifier = Modifier
                        .constrainAs(passwordTextField) {
                            top.linkTo(phoneTextField.bottom, 16.dp)
                            start.linkTo(parent.start, 24.dp)
                            end.linkTo(parent.end, 24.dp)
                            width = Dimension.fillToConstraints
                        },
                    errorMessage = uiState.passwordError
                )

                RoundedTextButton(
                    text = "Sign In",
                    modifier = Modifier
                        .height(50.dp)
                        .constrainAs(signInButton) {
                            bottom.linkTo(parent.bottom, 24.dp)
                            start.linkTo(parent.start, 24.dp)
                            end.linkTo(parent.end, 24.dp)
                            width = Dimension.fillToConstraints
                        },
                    enabled = true
                ) {

                }
            }
        }
    }


}



