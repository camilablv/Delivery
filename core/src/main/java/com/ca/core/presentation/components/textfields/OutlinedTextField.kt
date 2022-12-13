package com.ca.core.presentation.components.textfields

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Error
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun OutlinedTextField(
    value: MutableState<String>,
    modifier: Modifier,
    label: String,
    errorMessage: String?,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    var isError by remember(errorMessage) { mutableStateOf(errorMessage != null) }

    Column(
        modifier = modifier
    ) {
        OutlinedTextField(
            value = value.value,
            onValueChange = {
                isError = false
                value.value = it
            },
            modifier = Modifier
                .fillMaxWidth(1f)
                .semantics { contentDescription = "" }
                .shadow(0.dp, Theme.shapes.textField),
            textStyle = Theme.typography.bodyLarge,
            label = { Text(text = label, color = if (isError) Theme.colors.error else Theme.colors.onSurface) },
            visualTransformation = visualTransformation,
            keyboardOptions = KeyboardOptions(
                keyboardType = keyboardType,
                imeAction = ImeAction.Next
            ),
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Theme.colors.onSurface,
                focusedBorderColor = Theme.colors.surface,
                unfocusedBorderColor = Theme.colors.unfocusedTextFieldBorder,
                errorLabelColor = Theme.colors.error,
                cursorColor = Theme.colors.onSurface,
                backgroundColor = Theme.colors.surface,
                errorBorderColor = Theme.colors.error,
            ),
            isError = isError,
            singleLine = true,
            shape = Theme.shapes.textField,
            trailingIcon = {
                if (isError)
                    Icon(Icons.Filled.Error, "error_icon", tint = Theme.colors.error)
            },
            leadingIcon = leadingIcon
        )

        Text(
            text = if (isError) errorMessage!! else "",
            color = Theme.colors.error,
            style = Theme.typography.bodyLarge,
            modifier = Modifier
        )
    }


}

@Composable
@Preview
fun OutlinedTextFieldPreview() {
    val value = remember { mutableStateOf("4455555555") }

    DeliveryTheme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Theme.colors.background)
        ) {
            OutlinedTextField(
                value = value,
                modifier = Modifier
                    .padding(24.dp),
                label = "",
                errorMessage = null,
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
    }
}