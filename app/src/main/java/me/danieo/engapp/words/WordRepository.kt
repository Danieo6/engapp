package me.danieo.engapp.words

import android.content.Context
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import me.danieo.engapp.R
import me.danieo.engapp.words.exceptions.UnrecognizedLanguageLevelException

class WordRepository(private val context: Context) {
    private val database: WordDatabase =
        this.context.resources.openRawResource(R.raw.words).bufferedReader().use {
            Json.decodeFromString(it.readText())
        }

    fun fetchAllForLevel(level: String) {
        when (level) {
            "A1" -> this.database.A1
            "A2" -> this.database.A2
            "B1" -> this.database
            else -> throw UnrecognizedLanguageLevelException()
        }
    }
}
