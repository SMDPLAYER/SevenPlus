package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.sevenplusdictionary.di.service.room.dao.BaseDao
import uz.smd.sevenplusdictionary.di.service.room.entity.Translation

@Dao
interface TranslationDao : BaseDao<Translation> {
    @Query("SELECT * FROM translation where idWord=:wordId Limit 1")
    fun getTranslate(wordId:Int): Translation
}