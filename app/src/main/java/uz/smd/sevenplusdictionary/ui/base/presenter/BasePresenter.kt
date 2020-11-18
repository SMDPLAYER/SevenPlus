package uz.smd.sevenplusdictionary.ui.base.presenter

import com.arellomobile.mvp.MvpPresenter
import com.arellomobile.mvp.MvpView
import kotlinx.coroutines.*
import uz.smd.sevenplusdictionary.App

import uz.smd.sevenplusdictionary.di.service.base.BaseService
import uz.smd.sevenplusdictionary.utils.CompositeJob
import kotlin.coroutines.CoroutineContext

open class BasePresenter<View : MvpView> : MvpPresenter<View>(), CoroutineScope {

    private var baseService = BaseService()

    init {
        App.appComponent.inject(baseService)
    }

    val navigatorHolder
        get() = baseService.navigatorHolder

    val api
        get() = baseService.dao
    val apiUz
        get() = baseService.daoUz
    val category
        get() = baseService.category
    val categoryUz
        get() = baseService.categoryUz
    val translate
        get() = baseService.translate
    val translateUz
        get() = baseService.translateUz
    val favUz
        get() = baseService.favoritesUz
    val fav
        get() = baseService.favorites

    val prefs
        get() = baseService.prefs

    val tokenPrefs
        get() = baseService.tokenPrefs

    val router
        get() = baseService.router

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
    private val job: Job = SupervisorJob()
    val compositeJob = CompositeJob()

    override fun destroyView(view: View) {
        super.destroyView(view)
        destroy()
    }

    fun destroy() {
        job.cancelChildren()
        compositeJob.cancel()
    }

}