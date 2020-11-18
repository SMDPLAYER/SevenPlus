package uz.smd.sevenplusdictionary.di.service.room.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

data class TranslatedWords (
    var word: Word,
    var category:String?
)


@Entity
//    (indices = arrayOf(
//    Index(name = "IX_001",value = ["name","langId"], unique = false),
//    Index(name = "IX_002",value = ["id"], unique = false)
//))

data class Word(
    @PrimaryKey()
    val id:Int?,
    val name:String?,
    val langId:Int?,
    var transcription:String?
)