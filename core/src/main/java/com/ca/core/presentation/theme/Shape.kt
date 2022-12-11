package com.ca.core.presentation.theme

import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = DeliveryShapes(
    button = RoundedCornerShape(50),
    card = AbsoluteRoundedCornerShape(8.dp),
    textField = RoundedCornerShape(8.dp),
    navigationDrawer = CutCornerShape(0.dp),

)

data class DeliveryShapes(
    val button: Shape,
    val card: Shape,
    val textField: Shape,
    val navigationDrawer: Shape,
)



val LocalDeliveryShapes = staticCompositionLocalOf<DeliveryShapes> {
    error("No Diary Shapes Provided")
}