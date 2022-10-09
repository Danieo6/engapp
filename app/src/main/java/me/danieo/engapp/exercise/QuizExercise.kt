package me.danieo.engapp.exercise

import me.danieo.engapp.words.Word

data class QuizExercise(val questionWord: Word, val answers: Array<Word>) {
    var isCorrect: Boolean? = null
}
