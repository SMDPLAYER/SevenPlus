package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery

import uz.smd.sevenplusdictionary.di.service.room.entity.Word


@Dao
interface WordDao : BaseDao<Word> {
    @Query("SELECT * FROM word WHERE langId=1 and transcription!=:word  and  name LIKE  :words order by name  ")
    fun getAllEnRu(word:String="", words:String="ab%"): List<Word>
    @Query("SELECT * FROM word WHERE langId=0   and  name LIKE  :words order by name  ")
    fun getAllRuEn( words:String="аб%"): List<Word>

    @Query("SELECT *  from word WHERE langId=1 and  name LIKE :alpha order by name")
    fun getEnRuWords(alpha: String): List<Word>
    @Query("SELECT *  from word WHERE langId=0 and  name LIKE :alpha order by name")
    fun getRuEnWords(alpha: String): List<Word>
    @Query("SELECT *  from word WHERE id=:wordId")
    fun getWordById(wordId: Int): Word




    @RawQuery
    fun getSongViaQuery(query: SupportSQLiteQuery?): List<Word>?


}
// Usage of RawDao
//val tasksDao = AppDatabase.getDatabase(App.instance).productDao()
//val str=""
//var query = SimpleSQLiteQuery(
//    str
//)
//
//var song = tasksDao.getSongViaQuery(query)