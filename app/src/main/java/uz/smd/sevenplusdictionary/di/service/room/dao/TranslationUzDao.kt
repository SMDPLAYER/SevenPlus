package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.sevenplusdictionary.di.service.room.entity.Translation
import uz.smd.sevenplusdictionary.di.service.room.entity.TranslationUz

@Dao
interface TranslationUzDao : BaseDao<TranslationUz> {
    @Query("SELECT * FROM translationuz where idWord=:wordId Limit 1")
    fun getTranslate(wordId:Int): Translation



}