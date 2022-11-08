package me.danieo.engapp.game

import me.danieo.engapp.exercise.QuizExercise
import me.danieo.engapp.words.Word

data class Game(val quizExercises: Array<QuizExercise>, val exerciseDirection: Array<Boolean>) {
    var xpTotal: Int = 0
    var currentTask: Int = 0
}
