package uz.smd.sevenplusdictionary.di.service.room.dao

import androidx.room.Dao
import androidx.room.Query
import uz.smd.sevenplusdictionary.di.service.room.dao.BaseDao
import uz.smd.sevenplusdictionary.di.service.room.entity.Favorites
import uz.smd.sevenplusdictionary.di.service.room.entity.FavoritesUz
import uz.smd.sevenplusdictionary.di.service.room.entity.Translation

@Dao
interface FavoritesUzDao : BaseDao<FavoritesUz> {
    @Query("SELECT * FROM favoritesuz")
    fun getAllFavorites(): List<Favorites>
    @Query("SELECT * FROM favoritesuz where id=:id")
    fun isFavorite(id:Int): List<Favorites>




}