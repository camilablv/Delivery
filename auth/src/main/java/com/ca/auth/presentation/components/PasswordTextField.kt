package com.ca.auth.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.ca.core.presentation.components.textfields.OutlinedTextField

@Composable
fun PasswordTextField(
    value: MutableState<String>,
    modifier: Modifier,
    errorMessage: String?
) {
    OutlinedTextField(
        value = value,
        modifier = modifier,
        label = "Password",
        errorMessage = errorMessage,
        keyboardType = KeyboardType.Password,
        visualTransformation = PasswordVisualTransformation()
    )
}