package uz.smd.sevenplusdictionary.di.module

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import uz.smd.sevenplusdictionary.di.service.prefs.Prefs
import uz.smd.sevenplusdictionary.di.service.prefs.TokenPrefs

@Module
class AppModule(private val mApplication: Application) {

    private val SHARED_PREFERENCES_NAME = ""

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return mApplication.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }

    @Provides
    fun providePrefs(prefs: SharedPreferences): Prefs {
        return Prefs(prefs)
    }
    @Provides
    fun provideTokenPrefs(prefs: SharedPreferences): TokenPrefs {
        return TokenPrefs(prefs)
    }
}