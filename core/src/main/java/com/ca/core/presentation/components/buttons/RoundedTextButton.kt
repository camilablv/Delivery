package com.ca.core.presentation.components.buttons

import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.Theme

@Composable
fun RoundedTextButton(
    text: String,
    modifier: Modifier,
    enabled: Boolean,
    onClick: () -> Unit
) {
    Button(
        modifier = modifier,
        enabled = enabled,
        onClick = { onClick() },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Theme.colors.primary,
            disabledBackgroundColor = Theme.colors.disabledButtonBackground
        ),
        shape = Theme.shapes.button,
        elevation = ButtonDefaults.elevation(
            defaultElevation = 8.dp,
            disabledElevation = 0.dp,
            pressedElevation = 2.dp
        )
    ) {
        Text(text = text)
    }
}