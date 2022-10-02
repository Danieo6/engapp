package me.danieo.engapp.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import me.danieo.engapp.ui.theme.BackgroundColor
import me.danieo.engapp.ui.theme.EngAppTheme
import me.danieo.engapp.ui.theme.TextColor

@Composable
fun MyAppPreview(content: @Composable () -> Unit) {
    EngAppTheme {
        Surface(
            color = BackgroundColor,
            contentColor = TextColor,
            modifier = Modifier.fillMaxSize(),
        ) {
            Box(
                modifier = Modifier.padding(20.dp)
            ) {
                content()
            }
        }
    }
}

