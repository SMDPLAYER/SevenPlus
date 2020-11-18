package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.sevenplusdictionary.di.service.room.dao.BaseDao
import uz.smd.sevenplusdictionary.di.service.room.entity.Translation

@Dao
interface CategoryDao : BaseDao<Translation> {
    @Query("SELECT name FROM category where id=:categoryId")
    fun getCategory(categoryId:Int): String?



}