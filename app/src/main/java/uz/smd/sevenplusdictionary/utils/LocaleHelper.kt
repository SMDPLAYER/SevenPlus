package uz.smd.sevenplusdictionary.utils

import android.content.Context
import android.os.Build
import java.util.*

object LocaleHelper {

    private val SELECTED_LANGUAGE = "Locale.Helper.Selected.Language"
    private val LANG = "lang"

    fun onAttach(context: Context): Context {
        val defaultLang = Locale.getDefault().getDisplayLanguage()
        val lang = getPersistedData(context, defaultLang)
        return setLocale(context, lang)
    }

    fun onAttach(context: Context, defaultLanguage: String): Context {
        val lang = getPersistedData(context, defaultLanguage)
        return setLocale(context, lang)
    }

    fun getLanguage(context: Context): String? {
        return getPersistedData(context, Locale.getDefault().language)
    }

    fun setLocale(context: Context, language: String?): Context {
        persist(context, language)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            updateResources(context, language)
        } else updateResourcesLegacy(context, language)

    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String? {
        val preferences = context.getSharedPreferences(LANG, Context.MODE_PRIVATE)
        return preferences.getString(SELECTED_LANGUAGE, defaultLanguage)
    }

    private fun persist(context: Context, language: String?) {
        val preferences = context.getSharedPreferences(LANG, Context.MODE_PRIVATE)
        val editor = preferences.edit()

        editor.putString(SELECTED_LANGUAGE, language)
        editor.apply()
    }

    private fun updateResources(context: Context, language: String?): Context {
        val locale = Locale(language!!)
        Locale.setDefault(locale)

        val configuration = context.resources.configuration
        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }

    private fun updateResourcesLegacy(context: Context, language: String?): Context {
        val locale = Locale(language!!)
        Locale.setDefault(locale)

        val resources = context.resources

        val configuration = resources.configuration
        configuration.setLocale(locale)

        resources.updateConfiguration(configuration, resources.displayMetrics)

        return context
    }

}