package me.danieo.engapp.game

import android.content.Context
import me.danieo.engapp.exercise.ExerciseFactory
import me.danieo.engapp.exercise.QuizExercise
import me.danieo.engapp.game.exceptions.GameNotInitializedException
import me.danieo.engapp.user.UserService
import me.danieo.engapp.words.WordService
import kotlin.random.Random

class GameService(
    private val context: Context,
    private val wordService: WordService,
    private val exerciseFactory: ExerciseFactory,
    private val userService: UserService
    ) {
    private lateinit var currentGame: Game

    fun startNew() {
        val level = userService.getUserProfile().languageLevel
        val wordsToLearn = wordService.getAllForLevel(level).shuffled().take(10).toTypedArray()

        var quizExercises = arrayOf<QuizExercise>()
        var exerciseDirection = arrayOf<Boolean>()
        for (i in 0..9) {
            quizExercises += exerciseFactory.createQuizExercise(wordsToLearn[i], level)
            exerciseDirection += Random.nextBoolean()
        }

        this.currentGame = Game(quizExercises, exerciseDirection)
    }

    fun getCurrentGame(): Game {
        if (this::currentGame.isInitialized) {
            return this.currentGame
        }

        throw GameNotInitializedException()
    }

    fun nextTask(correct: Boolean): Int {
        if (this.currentGame.currentTask < 10) {
            this.currentGame.quizExercises[this.currentGame.currentTask].isCorrect = correct
            this.currentGame.xpTotal += if (correct) 5 else 0
        }

        println(this.currentGame.currentTask)
        return this.currentGame.currentTask++
    }

    fun finishCurrentGame() {
        val user = userService.getUserProfile()
        user.currentXp += this.currentGame.xpTotal
        user.totalXp += this.currentGame.xpTotal

        if (user.currentXp >= user.nextLevelXp) {
            user.level += 1
            user.currentXp = user.currentXp - user.nextLevelXp
            user.nextLevelXp = user.currentXp * user.level
        }

        this.userService.saveProfile(user)
    }
}
