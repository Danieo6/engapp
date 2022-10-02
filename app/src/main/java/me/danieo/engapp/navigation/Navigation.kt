package me.danieo.engapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.Services
import me.danieo.engapp.ui.HelpScreen
import me.danieo.engapp.ui.HomeScreen
import me.danieo.engapp.ui.SettingsScreen
import me.danieo.engapp.ui.StatsScreen

@Composable
fun Navigation(services: Services) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController, services.userService)
        }

        composable(route = Screen.HelpScreen.route) {
            HelpScreen(navController)
        }

        composable(route = Screen.StatsScreen.route) {
            StatsScreen(navController, services.resourcesService)
        }

        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController, services.userService)
        }
    }
}
