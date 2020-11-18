package uz.smd.sevenplusdictionary.ui.tasks.presenter

import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.smd.sevenplusdictionary.App
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import uz.smd.sevenplusdictionary.model.repository.BookRepository
import uz.smd.sevenplusdictionary.navigation.AppScreen
import uz.smd.sevenplusdictionary.ui.base.presenter.BasePresenter
import uz.smd.sevenplusdictionary.ui.tasks.view.TasksView


import javax.inject.Inject

@InjectViewState
class TasksPresenter : BasePresenter<TasksView>() {

    @Inject
    lateinit var repository: BookRepository

    override fun onFirstViewAttach() {
        App.appComponent.inject(this)
        super.onFirstViewAttach()
        loadChilds()


    }

    fun loadWithQuery(alpha: String) {
        compositeJob.add(
            CoroutineScope(Dispatchers.IO).launch {
                try {

                        when (tokenPrefs.locale) {
                            "UzEn" -> {
                                apiUz.getUzEnWords(alpha)
                                    .apply {
                                        val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                            "EnUz" -> {
                                apiUz.getEnUzWords(alpha)
                                    .apply {
                                        val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                            "EnRu" -> {
                                api.getEnRuWords(alpha)
                                    .apply {
                                        val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                            "RuEn" -> {
                                api.getRuEnWords(alpha)
                                    .apply {
                                        val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                        }
                        tokenPrefs.alpha = alpha



                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }

    private fun loadChilds() {
        viewState.showLoader(true)
        compositeJob.add(
            CoroutineScope(Dispatchers.IO).launch {
                try {
                        when (tokenPrefs.locale) {
                            "UzEn" -> {
                                apiUz.getAllUzEn()
                                    .apply {
val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.changeColorText("UzEn")
                                            viewState.showLoader(false)
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                            "EnUz" -> {
                                apiUz.getAllEnUz()
                                    .apply {
                                        val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.changeColorText("EnUz")
                                            viewState.showLoader(false)
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                            "EnRu" -> {
                                api.getAllEnRu().apply {
                                    val list=this
                                    CoroutineScope(Dispatchers.Main).launch {
                                        viewState.changeColorText("EnRu")
                                        viewState.showLoader(false)
                                        viewState.showTask(list)
                                    }

                                }
                            }
                            "RuEn" -> {
                                api.getAllRuEn()
                                    .apply {
                                        val list=this
                                        CoroutineScope(Dispatchers.Main).launch {
                                            viewState.changeColorText("RuEn")
                                            viewState.showLoader(false)
                                            viewState.showTask(list)
                                        }

                                    }
                            }
                            else -> {
                                api.getAllEnRu().apply {
                                    val list=this
                                    CoroutineScope(Dispatchers.Main).launch {
                                        viewState.changeColorText("EnRu")
                                        viewState.showLoader(false)
                                        viewState.showTask(list)
                                    }

                                }
                            }
                        }
                        tokenPrefs.alpha = ""
//                    }


                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }

    fun clickWord(it: Word) {

        tokenPrefs.transcription = it.transcription ?: ""
        tokenPrefs.wordName = it.name ?: ""
        tokenPrefs.wordId = it.id ?: 1
        router.navigateTo(AppScreen.TranslationScreen())
    }

    fun changeLocale(locale: String) {
        tokenPrefs.locale = locale
        if (tokenPrefs.alpha.isNotEmpty()) {
            viewState.changeColorText(locale)
            loadWithQuery(tokenPrefs.alpha)
        } else {
            loadChilds()

        }


    }


}