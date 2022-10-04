package me.danieo.engapp.words

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class Word(val en: String, val pl: String)

@Keep
@Serializable
data class WordDatabase (val A1: List<Word>, val A2: List<Word>, val B1: List<Word>)
