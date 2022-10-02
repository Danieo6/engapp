package me.danieo.engapp.resources

import android.content.Context
import android.content.res.Resources
import androidx.compose.ui.platform.LocalContext
import me.danieo.engapp.resources.exceptions.ResourceNotFoundException

class ResourcesService(val context: Context) {

    fun getStringIdentifier(key: String?): Int {
        key?.let {
            return this.context.resources.getIdentifier(key, "string", this.context.packageName)
        }

        throw ResourceNotFoundException()
    }
}
