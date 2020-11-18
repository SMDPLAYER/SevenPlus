package uz.smd.sevenplusdictionary.model.repository

import androidx.sqlite.db.SimpleSQLiteQuery
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.smd.sevenplusdictionary.di.service.room.AppDatabase
import uz.smd.sevenplusdictionary.di.service.room.dao.WordDao
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import javax.inject.Inject

class BookRepository @Inject constructor(libraryDatabase: AppDatabase) {

    private var bookDAO: WordDao = libraryDatabase.productDao()


    fun getBooks(  block: (List<Word>) -> Unit ) =
        CoroutineScope(Dispatchers.IO).launch {
        block(bookDAO.getAllEnRu())
        }



    fun insertBook(book: SimpleSQLiteQuery) {
        CoroutineScope(Dispatchers.IO).launch {
            bookDAO.getSongViaQuery(book)
        }
    }


}