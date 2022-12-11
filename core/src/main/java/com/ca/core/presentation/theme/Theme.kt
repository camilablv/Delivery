package com.ca.core.presentation.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

@Composable
fun DeliveryTheme(
    darkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    val colors = DarkColors

    CompositionLocalProvider(
        LocalDeliveryColors provides colors,
        LocalDeliveryTypography provides Typography,
        LocalDeliveryShapes provides Shapes,
        content = content
    )
}

object Theme {
    val colors: DeliveryColors
    @Composable
    get() = LocalDeliveryColors.current

    val typography: DeliveryTypography
    @Composable
    get() = LocalDeliveryTypography.current

    val shapes: DeliveryShapes
    @Composable
    get() = LocalDeliveryShapes.current
}