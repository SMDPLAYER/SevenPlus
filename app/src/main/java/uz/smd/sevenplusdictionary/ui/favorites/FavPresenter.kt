package uz.smd.sevenplusdictionary.ui.favorites

import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.launch
import uz.smd.sevenplusdictionary.App
import uz.smd.sevenplusdictionary.di.service.room.entity.Favorites
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import uz.smd.sevenplusdictionary.model.repository.BookRepository
import uz.smd.sevenplusdictionary.navigation.AppScreen
import uz.smd.sevenplusdictionary.ui.base.presenter.BasePresenter
import uz.smd.sevenplusdictionary.ui.tasks.view.TasksView
import uz.smd.sevenplusdictionary.utils.runOnUIThread
import uz.smd.sevenplusdictionary.utils.runOnWorkerThread

import javax.inject.Inject

@InjectViewState
class FavPresenter : BasePresenter<FavView>() {


    override fun onFirstViewAttach() {
        App.appComponent.inject(this)
        super.onFirstViewAttach()
        loadWithQuery()
    }

    fun loadWithQuery() {
        compositeJob.add(
            launch {
                try {

                    runOnWorkerThread {
                        fav.getAllFavorites()
                            .apply {
                                val favs= mutableListOf<Favorites>()
                              favs.addAll(this)
                                favUz.getAllFavorites().apply {
                                    favs.addAll(this)
                                    runOnUIThread {


                                        viewState.showTask(favs)
                                    }

                                }

                            }
                    }


                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }

}