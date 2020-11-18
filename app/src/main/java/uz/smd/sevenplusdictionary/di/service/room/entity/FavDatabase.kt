package uz.smd.sevenplusdictionary.di.service.room.entity

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.smd.sevenplusdictionary.di.service.room.dao.*
import uz.smd.sevenplusdictionary.di.service.room.entity.*

@Database(
    entities = [ Favorites::class,FavoritesUz::class],
    version = 1
)
abstract class FavDatabase : RoomDatabase() {
    abstract fun favoritesDao(): FavoritesDao
    abstract fun favoritesUzDao(): FavoritesUzDao
}