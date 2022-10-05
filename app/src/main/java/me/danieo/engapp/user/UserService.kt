package me.danieo.engapp.user

import android.content.Context
import me.danieo.engapp.user.exceptions.UserProfileNotCreatedException

class UserService(private val context: Context) {
    private val userRepository: UserRepository = UserRepository(context)

    fun getUserProfile(): User {
        return this.userRepository.findCurrent() ?: throw UserProfileNotCreatedException()
    }

    fun deleteUserProfile() {
        this.userRepository.deleteCurrent()
        println(this.userRepository.findCurrent())
    }

    fun isProfileCreated(): Boolean {
        if (this.userRepository.findCurrent() != null) {
            return true
        }

        return false
    }

    fun saveSettings(name: String, languageLevel: String) {
        val user = User(name, languageLevel)
        this.userRepository.persist(user)
    }
}
