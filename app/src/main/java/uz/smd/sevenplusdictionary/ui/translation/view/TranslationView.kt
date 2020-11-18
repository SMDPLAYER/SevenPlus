package uz.smd.sevenplusdictionary.ui.translation.view

import com.arellomobile.mvp.MvpView
import uz.smd.sevenplusdictionary.di.service.room.entity.Word

interface TranslationView : MvpView {
//    fun showTask(
//        listTasksDay:MutableList<TranslatedWords>,
//        wordName: String,
//        transcription: String
//    )
    fun showTask(listTasksDay: List<Word>)
    fun showTask(word: Word)
    fun favorite(isFav:Boolean)
    fun speak(speaking: String)
    fun showCategory(s: String?)

    fun showFromLocal(wordName: String, transcription: String)
//    fun showChids(children: ChildDto)
//    fun showChildsdialog(children:List<ChildDto>)
}