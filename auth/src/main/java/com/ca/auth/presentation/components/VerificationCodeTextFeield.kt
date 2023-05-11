package com.ca.auth.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ca.core.presentation.theme.DeliveryTheme
import com.ca.core.presentation.theme.Theme

@Composable
fun VerificationCodeTextField(
    value: MutableState<String>,
    modifier: Modifier,
    digitCount: Int
) {
    BasicTextField(
        value = value.value,
        onValueChange = {
            value.value = it
        },
        modifier = modifier
            .background(Color.Red),
        textStyle = Theme.typography.headerMiddle,
        singleLine = true,

    ) { textField ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            repeat(digitCount) { index ->

            }
            textField()
        }

    }
}

@Composable
@Preview
fun VerificationCodeTextFieldPreview() {
    val value = remember { mutableStateOf("") }

    DeliveryTheme {
        Surface(
            color = Theme.colors.background
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                VerificationCodeTextField(
                    value = value,
                    modifier = Modifier
                        .align(Alignment.Center),
                    6
                )
            }
        }
    }
}