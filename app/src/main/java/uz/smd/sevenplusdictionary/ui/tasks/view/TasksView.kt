package uz.smd.sevenplusdictionary.ui.tasks.view

import com.arellomobile.mvp.MvpView

import uz.smd.sevenplusdictionary.di.service.room.entity.Word

interface TasksView : MvpView {
    fun showTask(listTasksDay: List<Word>)
    fun showLoader(isTrue:Boolean)
    fun changeColorText(locale: String)
//    fun showChids(children: ChildDto)
//    fun showChildsdialog(children:List<ChildDto>)
}