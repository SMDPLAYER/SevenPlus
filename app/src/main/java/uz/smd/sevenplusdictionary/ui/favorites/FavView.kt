package uz.smd.sevenplusdictionary.ui.favorites

import com.arellomobile.mvp.MvpView
import uz.smd.sevenplusdictionary.di.service.room.entity.Favorites

import uz.smd.sevenplusdictionary.di.service.room.entity.Word

interface FavView : MvpView {
    fun showTask(listTasksDay: List<Favorites>)
    fun showLoader(isTrue:Boolean)
//    fun showChids(children: ChildDto)
//    fun showChildsdialog(children:List<ChildDto>)
}