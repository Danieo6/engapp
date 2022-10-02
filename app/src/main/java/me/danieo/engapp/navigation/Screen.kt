package me.danieo.engapp.navigation

sealed class Screen(val route: String) {
    object HomeScreen: Screen("home_screen")
    object HelpScreen: Screen("help_screen")
    object StatsScreen: Screen("stats_screen")
    object SettingsScreen: Screen("settings_screen")
}
