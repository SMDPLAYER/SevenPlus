package uz.smd.sevenplusdictionary.ui.news

import com.arellomobile.mvp.InjectViewState
import uz.smd.sevenplusdictionary.App

import uz.smd.sevenplusdictionary.ui.base.presenter.BasePresenter


@InjectViewState
class NewsPresenter : BasePresenter<NewsView>() {


    override fun onFirstViewAttach() {
        App.appComponent.inject(this)
        super.onFirstViewAttach()



    }





}