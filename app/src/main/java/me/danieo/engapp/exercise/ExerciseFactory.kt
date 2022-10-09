package me.danieo.engapp.exercise

import android.content.Context
import me.danieo.engapp.words.Word
import me.danieo.engapp.words.WordService

class ExerciseFactory(val context: Context, val wordService: WordService) {
    fun createQuizExercise(wordToLearn: Word, level: String): QuizExercise {
        var answers = arrayOf(wordToLearn)
        for (j in 0..2) {
            answers += wordService.getRandomForLevel(level, answers)
        }
        answers.shuffle()

        return QuizExercise(wordToLearn, answers)
    }
}
