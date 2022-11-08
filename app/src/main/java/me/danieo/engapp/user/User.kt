package me.danieo.engapp.user

import androidx.annotation.Keep
import kotlinx.serialization.Serializable
import me.danieo.engapp.words.WordCounter

@Keep
@Serializable
data class User(var name: String, var languageLevel: String) {
    var level: Int = 1
    var currentXp: Int = 0
    var nextLevelXp: Int = 50
    var totalXp: Int = 0
    var streakDays: Int = 0
    var streakHighest: Int = 0
    var wordsToLearn: List<WordCounter> = listOf<WordCounter>();
    var wordsWithMistakes: List<WordCounter> = listOf<WordCounter>();
}
