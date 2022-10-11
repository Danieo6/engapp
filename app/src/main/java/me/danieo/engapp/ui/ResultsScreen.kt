package me.danieo.engapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.MyApp
import me.danieo.engapp.R
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.MyAppPreview
import me.danieo.engapp.ui.components.TitleBar

@Composable
fun ResultsScreen(navController: NavController) {
    val totalXp = 0

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Spacer(
            modifier = Modifier.size(1.dp),
        )
        Column {
            TitleBar(textId = R.string.results_screen_good_job)
            Image(
                modifier = Modifier.padding(top = 64.dp),
                painter = painterResource(id = R.drawable.ic_results_highfive),
                contentDescription = null,
            )
            Text(
                modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
                textAlign = TextAlign.Center,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                text = stringResource(id = R.string.results_screen_earned_xp, totalXp),
            )
        }
        Column {
            CustomButton(
                text = stringResource(id = R.string.results_screen_continue),
                onClick = { /*TODO*/ }
            )
            CustomButton(
                modifier = Modifier.padding(top = 24.dp),
                text = stringResource(id = R.string.goto_homescreen),
                onClick = { navController.navigate(Screen.HomeScreen.route) },
                altColors = true,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultsScreenPreview() {
    MyAppPreview {
        ResultsScreen(rememberNavController())
    }
}
