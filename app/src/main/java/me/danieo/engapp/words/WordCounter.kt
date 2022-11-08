package me.danieo.engapp.words

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class WordCounter(var word: Word) {
    var counter: Int = 0
}