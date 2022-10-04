package me.danieo.engapp.user

import android.content.Context
import android.content.Context.MODE_PRIVATE
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.io.IOException

const val USER_PROFILE_FILE = "user-profile.data"

class UserRepository(val context: Context) {
    fun findCurrent(): User? {
        return try {
            this.context.openFileInput(USER_PROFILE_FILE).use { stream ->
                 return stream.bufferedReader().use {
                     Json.decodeFromString<User>(it.readText())
                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
            null
        }
    }

    fun deleteCurrent(): Boolean {
        return try {
            this.context.deleteFile(USER_PROFILE_FILE)
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }

    fun persist(user: User): Boolean {
        val userJson = Json.encodeToString(user)
        println(userJson)

        return try {
            this.context.openFileOutput(USER_PROFILE_FILE, MODE_PRIVATE).use { stream ->
                stream.write(userJson.toByteArray())
            }
            true
        } catch (e: IOException) {
            e.printStackTrace()
            false
        }
    }
}
