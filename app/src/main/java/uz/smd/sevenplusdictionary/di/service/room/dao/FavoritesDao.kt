package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.sevenplusdictionary.di.service.room.dao.BaseDao
import uz.smd.sevenplusdictionary.di.service.room.entity.Favorites
import uz.smd.sevenplusdictionary.di.service.room.entity.Translation

@Dao
interface FavoritesDao : BaseDao<Favorites> {
    @Query("SELECT * FROM favorites")
    fun getAllFavorites(): List<Favorites>
    @Query("SELECT * FROM favorites where id=:id")
    fun isFavorite(id:Int): List<Favorites>




}