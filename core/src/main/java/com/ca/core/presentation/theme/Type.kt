package com.ca.core.presentation.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val Typography = DeliveryTypography(
    headerMiddle = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 33.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    )
)

data class DeliveryTypography(
    val headerMiddle: TextStyle,
    val bodyLarge: TextStyle,
)

val LocalDeliveryTypography = staticCompositionLocalOf<DeliveryTypography> {
    error("No Delivery Typography Provided")
}