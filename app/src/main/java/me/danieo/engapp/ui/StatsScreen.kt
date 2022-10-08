package me.danieo.engapp.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.R
import me.danieo.engapp.Services
import me.danieo.engapp.navigation.Screen
import me.danieo.engapp.resources.ResourcesService
import me.danieo.engapp.ui.components.CustomButton
import me.danieo.engapp.ui.components.LevelBar
import me.danieo.engapp.ui.components.MyAppPreview
import me.danieo.engapp.ui.components.TitleBar
import me.danieo.engapp.ui.theme.PrimaryColor
import me.danieo.engapp.user.User
import me.danieo.engapp.user.UserService

@Composable
fun StatsScreen(navController: NavController, resourcesService: ResourcesService, userService: UserService) {
    val user: User = userService.getUserProfile()
    val statistics = listOf(
        Pair("current_xp", user.currentXp),
        Pair("next_level_xp", user.nextLevelXp),
        Pair("total_xp", user.totalXp),
        Pair("streak", user.streakDays),
        Pair("streak_highest", user.streakHighest),
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
    ) {
        TitleBar(textId = R.string.statscreen_title)

        Column {
            LevelBar(user.level, user.currentXp, user.nextLevelXp)
            Spacer(modifier = Modifier.size(40.dp))
            for (stat in statistics) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        text = stringResource(
                            id = resourcesService.getStringIdentifier("statscreen_${stat.first}")
                        ),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text =
                            if (stat.first.contains("streak"))
                                stringResource(id = R.string.days, stat.second)
                            else
                                stringResource(id = R.string.xp, stat.second),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = PrimaryColor,
                    )
                }
            }
        }

        CustomButton(
            text = stringResource(R.string.goto_homescreen),
            onClick = { navController.navigate(Screen.HomeScreen.route) },
        )
    }
}

@Preview(showBackground = true)
@Composable
fun StatsScreenPreview() {
    MyAppPreview {
        val services = Services(LocalContext.current)
        StatsScreen(rememberNavController(), services.resourcesService, services.userService)
    }
}
