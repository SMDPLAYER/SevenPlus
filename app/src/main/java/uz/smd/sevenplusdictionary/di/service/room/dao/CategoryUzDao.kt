package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.sevenplusdictionary.di.service.room.dao.BaseDao
import uz.smd.sevenplusdictionary.di.service.room.entity.Translation
import uz.smd.sevenplusdictionary.di.service.room.entity.TranslationUz

@Dao
interface CategoryUzDao : BaseDao<TranslationUz> {
    @Query("SELECT name FROM categoryuz where id=:categoryId")
    fun getCategory(categoryId:Int): String?



}