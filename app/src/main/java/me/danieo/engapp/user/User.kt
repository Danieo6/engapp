package me.danieo.engapp.user

import androidx.annotation.Keep
import kotlinx.serialization.Serializable

@Keep
@Serializable
data class User(var name: String, var languageLevel: String)
