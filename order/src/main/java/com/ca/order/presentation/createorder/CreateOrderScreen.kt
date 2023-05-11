package com.ca.order.presentation.createorder

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import com.ca.core.presentation.theme.Theme

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun CreateOrderScreen() {

    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState
    ) {
        Surface(
            color = Theme.colors.background
        ) {

        }
    }
}