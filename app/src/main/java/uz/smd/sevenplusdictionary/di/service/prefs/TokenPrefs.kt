package uz.smd.sevenplusdictionary.di.service.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class TokenPrefs @Inject constructor(private val preferences: SharedPreferences) {

    private val TOKEN_KEY = "token"
    private val trans = "trans"
    private val word = "wprd"
    private val CHILD_ID = "childId"
    private val IS_FIRST = "isFirst"

    fun isLogged(): Boolean {
        val token = preferences.getString(TOKEN_KEY, "") ?: ""
        return token != ""
    }

    fun clearToken() {
        preferences.edit().clear().apply()
    }


    var transcription : String
        get() = preferences.getString(trans, "") ?: ""
        set(value) {
            preferences.edit().putString(trans, value).apply()
        }
    var locale : String
        get() = preferences.getString("locale", "EnUz") ?: "EnUz"
        set(value) {
            preferences.edit().putString("locale", value).apply()
        }
    var alpha : String
        get() = preferences.getString("alpha", "") ?: ""
        set(value) {
            preferences.edit().putString("alpha", value).apply()
        }
    var wordName : String
        get() = preferences.getString(word, "") ?: ""
        set(value) {
            preferences.edit().putString(word, value).apply()
        }
    var wordId : Int
        get() = preferences.getInt(CHILD_ID, 0)
        set(value) {
            preferences.edit().putInt(CHILD_ID, value).apply()
        }
    var isFirst : Int
        get() = preferences.getInt(IS_FIRST, 12)
        set(value) {
            preferences.edit().putInt(IS_FIRST, value).apply()
        }
    var isFav : Int
        get() = preferences.getInt("IS_FAV", 12)
        set(value) {
            preferences.edit().putInt("IS_FAV", value).apply()
        }
}
