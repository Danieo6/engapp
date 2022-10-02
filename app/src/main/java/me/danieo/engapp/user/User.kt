package me.danieo.engapp.user

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class User(var name: String, var languageLevel: String) {
    var level: Int = 1
    var currentXp: Int = 0
    var nextLevelXp: Int = 50
    var streakDays: Int = 0
}
