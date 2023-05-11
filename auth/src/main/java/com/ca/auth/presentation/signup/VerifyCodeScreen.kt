package com.ca.auth.presentation.signup

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ca.auth.presentation.components.VerificationCodeTextField
import com.ca.core.presentation.components.buttons.RoundedTextButton
import com.ca.core.presentation.theme.Theme
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VerifyCodeScreen(
    viewModel: SignUpViewModelImpl = koinViewModel(),
    onVerifyClick: (String) -> Unit,
    onVerificationCompleted: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val scaffoldState = rememberScaffoldState()
    val uiState by viewModel.uiState.collectAsState()
    val code = remember { mutableStateOf("") }

    if (uiState.signUpSuccessful) {
        onVerificationCompleted()
    }

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Surface(
            color = Theme.colors.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                VerificationCodeTextField(
                    value = code,
                    modifier = Modifier
                        .align(Alignment.Center),
                    6
                )

                RoundedTextButton(
                    text = "Verify",
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth(),
                    enabled = true
                ) {
                    onVerifyClick(code.value)
                }
            }
        }
    }
}

