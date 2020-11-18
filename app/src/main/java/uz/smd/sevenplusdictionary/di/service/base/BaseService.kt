package uz.smd.sevenplusdictionary.di.service.base

import ru.terrakok.cicerone.NavigatorHolder
import uz.smd.sevenplusdictionary.di.service.prefs.Prefs
import uz.smd.sevenplusdictionary.di.service.prefs.TokenPrefs
import uz.smd.sevenplusdictionary.di.service.room.dao.*
import uz.smd.sevenplusdictionary.navigation.AppRouter
import javax.inject.Inject

class BaseService {


    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    @Inject
    lateinit var router: AppRouter

    @Inject
    lateinit var prefs: Prefs

    @Inject
    lateinit var tokenPrefs: TokenPrefs
    @Inject
    lateinit var dao: WordDao
    @Inject
    lateinit var category: CategoryDao
    @Inject
    lateinit var translate: TranslationDao
    @Inject
    lateinit var favorites: FavoritesDao
    @Inject
    lateinit var daoUz: WordUzDao
    @Inject
    lateinit var categoryUz: CategoryUzDao
    @Inject
    lateinit var translateUz: TranslationUzDao
    @Inject
    lateinit var favoritesUz: FavoritesUzDao

}