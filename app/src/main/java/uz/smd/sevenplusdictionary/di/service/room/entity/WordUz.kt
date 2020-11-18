package uz.smd.sevenplusdictionary.di.service.room.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

data class TranslatedWordsUz (
    var word: WordUz,
    var category:String?
)


@Entity
data class WordUz(
    @PrimaryKey()
    val id:Int?,
    val name:String?,
    val langId:Int?,
    var transcription:String?
)