package me.danieo.engapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.R
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.MyAppPreview
import me.danieo.engapp.ui.components.TitleBar
import me.danieo.engapp.ui.theme.PrimaryColor

@Composable
fun HelpScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        TitleBar(textId = R.string.helpscreen_title)
        Column {
            Text(
                text = stringResource(id = R.string.helpscreen_description),
                color = PrimaryColor,
                textAlign = TextAlign.Justify,
            )
            Spacer (modifier = Modifier.size(16.dp))
            Text(
                text = stringResource(id = R.string.helpscreen_created_by),
                modifier = Modifier.fillMaxWidth(),
                color = PrimaryColor,
                textAlign = TextAlign.Center,
            )
            Text(
                text = stringResource(id = R.string.helpscreen_help),
                color = PrimaryColor,
                textAlign = TextAlign.Center,
            )
        }
        CustomButton(
            text = stringResource(R.string.goto_homescreen),
            onClick = { navController.navigate(Screen.HomeScreen.route) }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HelpScreenPreview() {
    MyAppPreview {
        HelpScreen(rememberNavController())
    }
}
