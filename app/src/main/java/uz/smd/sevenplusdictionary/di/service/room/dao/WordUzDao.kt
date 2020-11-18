package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.RawQuery
import androidx.sqlite.db.SupportSQLiteQuery
import uz.smd.sevenplusdictionary.di.service.room.entity.Word

import uz.smd.sevenplusdictionary.di.service.room.entity.WordUz


@Dao
interface WordUzDao : BaseDao<WordUz> {
    @Query("SELECT * FROM worduz WHERE langId=0  and  name LIKE  :words order by name")
    fun getAllUzEn(words:String="ab%"): List<Word>
    @Query("SELECT * FROM worduz WHERE langId=1 and transcription!=:word  and  name LIKE  :words order by name")
    fun getAllEnUz(word:String="",words:String="ab%"): List<Word>

    @Query("SELECT *  from worduz WHERE langId=1 and  name LIKE :alpha order by name")
    fun getEnUzWords(alpha: String): List<Word>
    @Query("SELECT *  from worduz WHERE langId=0 and  name LIKE :alpha order by name")
    fun getUzEnWords(alpha: String): List<Word>
    @Query("SELECT *  from worduz WHERE id=:wordId")
    fun getWordById(wordId: Int): Word




    @RawQuery
    fun getSongViaQuery(query: SupportSQLiteQuery?): List<WordUz>?


}
// Usage of RawDao
//val tasksDao = AppDatabase.getDatabase(App.instance).productDao()
//val str=""
//var query = SimpleSQLiteQuery(
//    str
//)
//
//var song = tasksDao.getSongViaQuery(query)