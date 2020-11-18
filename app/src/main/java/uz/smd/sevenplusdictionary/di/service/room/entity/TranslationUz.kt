package uz.smd.sevenplusdictionary.di.service.room.entity

import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity
//    (indices = arrayOf(Index(name = "IX_003",value = ["idWord"], unique = false),Index(value = ["idWord"], unique = false)))
class TranslationUz(
    @PrimaryKey()
    val id:Int?,
    val idWord:Int?,
    val idTranslation:Int?,
    val idCategory:Int?,
)