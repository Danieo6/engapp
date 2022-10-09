package me.danieo.engapp.words

import android.content.Context
import kotlin.random.Random

class WordService(private val context: Context) {
    private val wordRepository: WordRepository = WordRepository(context)

    fun getAllForLevel(level: String): List<Word> {
        return this.wordRepository.fetchAllForLevel(level);
    }

    fun getRandomForLevel(level: String, excludeWords: Array<Word> = arrayOf<Word>()): Word {
        val wordList = this.wordRepository.fetchAllForLevel(level)

        var randomWord: Word = wordList[this.getRandomIndex(wordList.size)]
//        while (excludeWords.contains(randomWord)) {
//            randomWord = wordList[this.getRandomIndex(wordList.size)]
//            println("Retrying generation...")
//        }

        return randomWord
    }

    private fun getRandomIndex(wordListSize: Int): Int {
        return IntRange(0, wordListSize - 1).random()
    }
}
