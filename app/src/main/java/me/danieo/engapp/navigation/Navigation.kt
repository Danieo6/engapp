package me.danieo.engapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import me.danieo.engapp.Services
import me.danieo.engapp.ui.*

@Composable
fun Navigation(services: Services) {
    val navController = rememberNavController()
    var startDestination = Screen.HomeScreen.route

    if (!services.userService.isProfileCreated()) {
        startDestination = Screen.SettingsScreen.route
    }

    NavHost(navController = navController, startDestination = startDestination) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController, services.userService)
        }

        composable(route = Screen.HelpScreen.route) {
            HelpScreen(navController)
        }

        composable(route = Screen.StatsScreen.route) {
            StatsScreen(navController, services.resourcesService, services.userService)
        }

        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController, services.userService)
        }

        composable(route = Screen.QuizExerciseScreen.route) {
            QuizExerciseScreen(navController)
        }

        composable(route = Screen.PairExerciseScreen.route) {
            PairExerciseScreen(navController)
        }
    }
}
