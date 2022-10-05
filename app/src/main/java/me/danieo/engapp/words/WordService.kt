package me.danieo.engapp.words

import android.content.Context

class WordService(private val context: Context) {
    private val wordRepository: WordRepository = WordRepository(context)
}
