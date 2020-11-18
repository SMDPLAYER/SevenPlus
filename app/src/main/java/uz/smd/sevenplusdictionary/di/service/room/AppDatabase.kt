package uz.smd.sevenplusdictionary.di.service.room

import androidx.room.Database
import androidx.room.RoomDatabase
import uz.smd.sevenplusdictionary.di.service.room.dao.*
import uz.smd.sevenplusdictionary.di.service.room.entity.*

@Database(
    entities = [Category::class,Translation::class, Word::class,
            CategoryUz::class,TranslationUz::class, WordUz::class],
    version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): WordDao
    abstract fun translationDao(): TranslationDao
    abstract fun categoryDao(): CategoryDao
    abstract fun productUzDao(): WordUzDao
    abstract fun translationUZDao(): TranslationUzDao
    abstract fun categoryUzDao(): CategoryUzDao




//    companion object {
//        @Volatile
//        private var INSTANCE: AppDatabase? = null
//
//        fun getDatabase(context: Context): AppDatabase {
//            val tempInstance = INSTANCE
//            if (tempInstance != null) {
//                return tempInstance
//            }
//            synchronized(this) {
//                val instance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDatabase::class.java,
//                    "ruen"
//                ).createFromAsset("ruen.db")
//                    .build()
//                INSTANCE = instance
//                return instance
//            }
//        }
//    }

}