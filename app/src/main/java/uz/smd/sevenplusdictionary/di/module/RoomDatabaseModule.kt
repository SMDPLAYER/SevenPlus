package uz.smd.sevenplusdictionary.di.module

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import uz.smd.sevenplusdictionary.di.service.room.AppDatabase
import javax.inject.Singleton

@Module
class RoomDatabaseModule(application: Application) {

    private var libraryApplication = application
    private lateinit var libraryDatabase: AppDatabase

    @Volatile
    private var INSTANCE: AppDatabase? = null

    @Singleton
    @Provides
    fun providesRoomDatabase(): AppDatabase {
        val tempInstance = INSTANCE
        if (tempInstance != null) {
            return tempInstance
        }else
        synchronized(this) {
        libraryDatabase = Room.databaseBuilder(libraryApplication,  AppDatabase::class.java, "library_database")
            .createFromAsset("ruens.db")
            .build()
            INSTANCE=libraryDatabase
        return libraryDatabase
    }}

    @Singleton
    @Provides
    fun productDao(libraryDatabase: AppDatabase) = libraryDatabase.productDao()

    @Singleton
    @Provides
    fun translationDao(libraryDatabase: AppDatabase) = libraryDatabase.translationDao()
    @Singleton
    @Provides
    fun categoryDao(libraryDatabase: AppDatabase) = libraryDatabase.categoryDao()

    @Singleton
    @Provides
    fun producuztDao(libraryDatabase: AppDatabase) = libraryDatabase.productUzDao()

    @Singleton
    @Provides
    fun translatiouznDao(libraryDatabase: AppDatabase) = libraryDatabase.translationUZDao()
    @Singleton
    @Provides
    fun categoryuzDao(libraryDatabase: AppDatabase) = libraryDatabase.categoryUzDao()



}