package me.danieo.engapp.user

import android.content.Context
import me.danieo.engapp.user.exceptions.UserProfileNotCreatedException
import me.danieo.engapp.words.WordService

class UserService(context: Context, private val wordService: WordService) {
    private val userRepository: UserRepository = UserRepository(context)

    fun getUserProfile(): User {
        return this.userRepository.findCurrent() ?: throw UserProfileNotCreatedException()
    }

    fun deleteUserProfile() {
        this.userRepository.deleteCurrent()
    }

    fun isProfileCreated(): Boolean {
        if (this.userRepository.findCurrent() != null) {
            return true
        }

        return false
    }

    fun saveSettings(name: String, languageLevel: String) {
        val user = User(name, languageLevel)

        if (!this.isProfileCreated() || this.getUserProfile().languageLevel != languageLevel) {
            user.wordsToLearn = wordService.mapWordToWordCounterList(wordService.getAllForLevel(languageLevel))
        }
        println(user)
        this.userRepository.persist(user)
    }

    fun saveProfile(user: User) {
        this.userRepository.persist(user)
    }
}
