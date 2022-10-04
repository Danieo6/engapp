package me.danieo.engapp

import android.content.Context
import me.danieo.engapp.resources.ResourcesService
import me.danieo.engapp.user.UserService
import me.danieo.engapp.words.WordService

class Services(context: Context) {
    val resourcesService: ResourcesService
    val userService: UserService
    val wordService: WordService

    init {
        resourcesService = ResourcesService(context)
        userService = UserService(context)
        wordService = WordService(context)
    }
}
