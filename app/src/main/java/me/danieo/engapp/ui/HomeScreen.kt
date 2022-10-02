package me.danieo.engapp.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.R
import me.danieo.engapp.Services
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.CustomIcon
import me.danieo.engapp.ui.components.LevelBar
import me.danieo.engapp.ui.components.MyAppPreview
import me.danieo.engapp.ui.theme.PrimaryColor
import me.danieo.engapp.user.User
import me.danieo.engapp.user.UserService

@Composable
fun HomeScreen(navController: NavController, userService: UserService) {
    val user: User = userService.getUserProfile()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = {
                navController.navigate(Screen.HelpScreen.route)
            }) {
                CustomIcon(iconName = "help", size = 48.dp)
            }
            IconButton(onClick = {
                navController.navigate(Screen.SettingsScreen.route)
            }) {
                CustomIcon(iconName = "settings", size = 48.dp)
            }
        }

        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                stringResource(R.string.homescreen_hello, user.name),
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
            )
            Text(
                stringResource(R.string.homescreen_ready),
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_homescreen_illustration),
                contentDescription = null,
            )
        }

        Column {
            CustomButton(
                textResourceId = R.string.homescreen_continue,
                onClick = {}
            )
            CustomButton(
                textResourceId = R.string.homescreen_show_stats,
                modifier = Modifier.padding(top = 16.dp),
                altColors = true,
                onClick = {
                    navController.navigate(Screen.StatsScreen.route)
                },
            )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            LevelBar(user.level, user.currentXp, user.nextLevelXp)
            Text(
                text = stringResource(id = R.string.homescreen_streak, user.streakDays),
                modifier = Modifier.padding(top = 12.dp),
                fontWeight = FontWeight.Bold,
                color = PrimaryColor,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    MyAppPreview {
        val services = Services(LocalContext.current)
        HomeScreen(rememberNavController(), services.userService)
    }
}
