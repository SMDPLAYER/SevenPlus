package uz.smd.sevenplusdictionary.ui.base.view

import com.arellomobile.mvp.MvpView

interface ProgressView : MvpView{
    fun showProgress()
    fun hideProgress()
}
