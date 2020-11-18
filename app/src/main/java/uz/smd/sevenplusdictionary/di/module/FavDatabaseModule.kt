package uz.smd.sevenplusdictionary.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
//import uz.smd.sevenplusdictionary.di.service.room.AppDatabase
import uz.smd.sevenplusdictionary.di.service.room.entity.FavDatabase
import javax.inject.Singleton

@Module
class FavDatabaseModule(application: Application) {

    private var libraryApplication = application
    private lateinit var libraryDatabase: FavDatabase

    @Volatile
    private var INSTANCE: FavDatabase? = null

    @Singleton
    @Provides
    fun getDatabase(): FavDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }
        synchronized(this) {
             libraryDatabase = Room.databaseBuilder(
                libraryApplication,
                FavDatabase::class.java,
                "app_database"
            )
                .build()
            INSTANCE = libraryDatabase
            return libraryDatabase
        }
    }


    @Singleton
    @Provides
    fun favoritesDao(libraryDatabase: FavDatabase) = libraryDatabase.favoritesDao()

    @Singleton
    @Provides
    fun favoritesuzDao(libraryDatabase: FavDatabase) = libraryDatabase.favoritesUzDao()


}