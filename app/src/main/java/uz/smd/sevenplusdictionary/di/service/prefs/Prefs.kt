package uz.smd.sevenplusdictionary.di.service.prefs

import android.content.SharedPreferences

class Prefs(private val prefs: SharedPreferences) {

    companion object {
        const val TOKEN_KEY = "token"
    }

    private val USER_ID_KEY = "user_id"

    fun isLogged(): Boolean {
        val token = prefs.getString(TOKEN_KEY, "") ?: ""
        return token != ""
    }

    var userId: Long
        get() = prefs.getLong(USER_ID_KEY, -1L)
        set(value) {
            prefs.edit().putLong(USER_ID_KEY, value).apply()
        }

}