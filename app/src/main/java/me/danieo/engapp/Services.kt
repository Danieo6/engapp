package me.danieo.engapp

import android.content.Context
import me.danieo.engapp.exercise.ExerciseFactory
import me.danieo.engapp.game.GameService
import me.danieo.engapp.resources.ResourcesService
import me.danieo.engapp.user.UserService
import me.danieo.engapp.words.WordService

class Services(context: Context) {
    val resourcesService: ResourcesService
    val userService: UserService
    val wordService: WordService
    val exerciseFactory: ExerciseFactory
    val gameService: GameService

    init {
        resourcesService = ResourcesService(context)
        wordService = WordService(context)
        userService = UserService(context, wordService)
        exerciseFactory = ExerciseFactory(context, wordService)
        gameService = GameService(context, wordService, exerciseFactory, userService)
    }
}
