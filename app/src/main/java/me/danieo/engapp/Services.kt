package me.danieo.engapp

import android.content.Context
import me.danieo.engapp.resources.ResourcesService
import me.danieo.engapp.settings.SettingsService
import me.danieo.engapp.user.UserService

class Services(context: Context) {
    val resourcesService: ResourcesService
    val userService: UserService

    init {
        resourcesService = ResourcesService(context)
        userService = UserService(context)
    }
}
