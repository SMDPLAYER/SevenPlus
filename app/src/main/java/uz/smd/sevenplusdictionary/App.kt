package uz.smd.sevenplusdictionary

import android.app.Application
import android.content.Context
import android.content.res.Configuration
import uz.smd.sevenplusdictionary.di.AppComponent
import uz.smd.sevenplusdictionary.di.DaggerAppComponent
import uz.smd.sevenplusdictionary.di.module.*
import uz.smd.sevenplusdictionary.utils.LocaleHelper

class App : Application() {

    companion object {
        lateinit var appComponent: AppComponent
    }




    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(this))
//            .webModule(WebModule(this))
            .navigationModule(NavigationModule())
            .roomDatabaseModule(RoomDatabaseModule(this))
            .favDatabaseModule(FavDatabaseModule(this))
//            .repositoryModule(RepositoryModule())
            .build()
    }

    override fun attachBaseContext(base: Context?) {
        if (base == null) {
            super.attachBaseContext(base)
        } else {
            super.attachBaseContext(LocaleHelper.onAttach(base))
        }
        // MultiDex.install(this)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        LocaleHelper.onAttach(this)
    }

}