package uz.smd.sevenplusdictionary.ui.news

import com.arellomobile.mvp.MvpView

import uz.smd.sevenplusdictionary.di.service.room.entity.Word

interface NewsView : MvpView {

    fun showLoader(isTrue:Boolean)
//    fun showChids(children: ChildDto)
//    fun showChildsdialog(children:List<ChildDto>)
}