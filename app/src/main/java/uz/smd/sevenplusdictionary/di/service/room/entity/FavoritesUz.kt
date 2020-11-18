package uz.smd.sevenplusdictionary.di.service.room.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoritesUz(
    @PrimaryKey
    var id: Int?,
    var name: String?,
    var translation: String?
)