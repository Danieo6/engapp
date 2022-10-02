package me.danieo.engapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import me.danieo.engapp.navigation.Navigation
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.ui.theme.BackgroundColor
import me.danieo.engapp.ui.theme.EngAppTheme
import me.danieo.engapp.ui.theme.TextColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EngAppTheme {
                MyApp()
            }
        }
    }
}

@Composable
fun MyApp() {
    val services = Services(LocalContext.current)

    Surface(
        color = BackgroundColor,
        contentColor = TextColor,
        modifier = Modifier.fillMaxSize(),
    ) {
        Box(
            modifier = Modifier.padding(20.dp)
        ) {
            Navigation(services)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EngAppTheme {
        MyApp()
    }
}
