package me.danieo.engapp.ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import me.danieo.engapp.R
import me.danieo.engapp.ui.theme.PrimaryColor

val icons = mapOf(
    "help" to R.drawable.ic_baseline_help_24,
    "settings" to R.drawable.ic_baseline_settings_24,
)

@Composable
fun CustomIcon(iconName: String, tint: Color = PrimaryColor, size: Dp = 24.dp) {
    var iconResource: Int? = icons[iconName]
    if (iconResource == null) {
        iconResource = R.drawable.ic_baseline_android_24
    }

    Icon(
        painter = painterResource(id = iconResource),
        contentDescription = null,
        tint = tint,
        modifier = Modifier.size(size),
    )
}