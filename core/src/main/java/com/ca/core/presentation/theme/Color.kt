package com.ca.core.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)
val DarkGrey = Color(0xFF121212)
val Black = Color(0xFF000000)
val Purple400 = Color(0xFFab47bc)
val Purple100 = Color(0xFFe1bee7)
val DarkRed = Color(0xFFB00020)
val Grey50 = Color(0xFFfafafa)

val DarkColors = DeliveryColors(
    background = Black,
    primary = Purple400,
    secondary = Purple100,
    surface = DarkGrey,
    error = DarkRed,
    onBackground = Grey50,
    onPrimary = Grey50,
    onSecondary = DarkGrey,
    onSurface = Grey50,
    onError = Grey50
)

data class DeliveryColors(
    val background: Color,
    val primary: Color,
    val secondary: Color,
    val surface: Color,
    val error:Color,
    val onBackground: Color,
    val onPrimary: Color,
    val onSecondary: Color,
    val onSurface: Color,
    val onError: Color
)

val LocalDeliveryColors = staticCompositionLocalOf<DeliveryColors> {
    error("No Delivery Colors Provided")
}

