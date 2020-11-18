package uz.smd.sevenplusdictionary.ui.translation.presenter

import com.arellomobile.mvp.InjectViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import uz.smd.sevenplusdictionary.App
import uz.smd.sevenplusdictionary.di.service.room.entity.Favorites
import uz.smd.sevenplusdictionary.di.service.room.entity.FavoritesUz
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import uz.smd.sevenplusdictionary.model.repository.BookRepository
import uz.smd.sevenplusdictionary.ui.base.presenter.BasePresenter

import uz.smd.sevenplusdictionary.ui.translation.view.TranslationView
import uz.smd.sevenplusdictionary.utils.runOnUIThread
import uz.smd.sevenplusdictionary.utils.runOnWorkerThread
import javax.inject.Inject

@InjectViewState
class TranslationPresenter : BasePresenter<TranslationView>() {

    @Inject
    lateinit var repository: BookRepository

    override fun onFirstViewAttach() {
        App.appComponent.inject(this)
        super.onFirstViewAttach()
        loadChilds()
        loadWithQuery(tokenPrefs.wordName)

    }

    fun loadWithQuery(alphas: String) {
        compositeJob.add(
            CoroutineScope(Dispatchers.IO).launch {
                try {
                        val alpha = "$alphas%"
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




                } catch (t: Throwable) {
                    t.printStackTrace()
                }
            }
        )
    }
//    fun loadWithQuery(alpha: String) {
//
//        compositeJob.add(
//            launch {
//                try {
//                    runOnWorkerThread {
//                        val alphas = "$alpha%"
//
//                        api.getEnRuWords(alphas)
//                            .apply {
//                                var k = this
//                                runOnUIThread {
//                                    viewState.showTask(k)
//                                }
//
//                            }
//                    }
//
//
//                } catch (t: Throwable) {
//                    t.printStackTrace()
//                }
//            }
//        )
//    }

    private fun loadChilds() {
        viewState.showFromLocal(tokenPrefs.wordName, tokenPrefs.transcription)
        compositeJob.add(
            CoroutineScope(Dispatchers.IO).launch {
                try {
                    if (tokenPrefs.locale == "UzEn" || tokenPrefs.locale == "EnUz") {
                        favUz.isFavorite(tokenPrefs.wordId).apply {
                            val list = this
                            CoroutineScope(Dispatchers.Main).launch {
                                if (list.isNotEmpty()) {
                                    viewState.favorite(true)
                                } else
                                    viewState.favorite(false)

                            }
                        }
                        translateUz.getTranslate(tokenPrefs.wordId).apply {
                            val k = this
                            categoryUz.getCategory(k.idCategory ?: 1).apply {
                                val l = this
                                CoroutineScope(Dispatchers.Main).launch {
                                    viewState.showCategory(l)
                                }
                            }
                            apiUz.getWordById(k.idTranslation ?: 1).apply {
                                val list = this
                                CoroutineScope(Dispatchers.Main).launch {
                                    viewState.showTask(list)
                                }
                            }
                        }

                    } else {
                        fav.isFavorite(tokenPrefs.wordId).apply {
                            val list = this
                            CoroutineScope(Dispatchers.Main).launch {
                                if (list.isNotEmpty()) {

                                    viewState.favorite(true)

                                } else
                                    viewState.favorite(false)

                            }
                        }
                        translate.getTranslate(tokenPrefs.wordId).apply {
                            val k = this
                            category.getCategory(k.idCategory ?: 1).apply {
                                val l = this
                                CoroutineScope(Dispatchers.Main).launch {
                                    viewState.showCategory(l)
                                }
                            }
                            api.getWordById(k.idTranslation ?: 1).apply {
                                val list = this
                                CoroutineScope(Dispatchers.Main).launch {
                                    viewState.showTask(list)
                                }
                            }
//                            val wordList: MutableList<TranslatedWords> = mutableListOf()
//                            this.forEach {
//                                api2.getCategory(it.idCategory ?: 1).apply {
//                                    val k = this
//                                    api.getWordById(it.idTranslation ?: 1).apply {
//                                        wordList.add(TranslatedWords(this, k))
//                                    }
//                                }
//                            }
//                            runOnUIThread {
//                                viewState.showTask(
//                                    wordList,
//                                    tokenPrefs.wordName,
//                                    tokenPrefs.transcription
//                                )
//                            }


                        }
                    }


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
        loadChilds()
        loadWithQuery(tokenPrefs.wordName)
    }

    fun addFav(text: String?) {
        runOnWorkerThread {
            if (tokenPrefs.locale == "UzEn" || tokenPrefs.locale == "EnUz") {
                favUz.isFavorite(tokenPrefs.wordId).apply {

                    if (this.isNotEmpty()) {
                        favUz.delete(FavoritesUz(tokenPrefs.wordId, tokenPrefs.wordName, text))
                        runOnUIThread {
                            viewState.favorite(false)
                        }
                    } else {
                        favUz.insert(FavoritesUz(tokenPrefs.wordId, tokenPrefs.wordName, text))
                        runOnUIThread {
                            viewState.favorite(true)
                        }
                    }

                }
            } else {
                fav.isFavorite(tokenPrefs.wordId).apply {
                    if (this.isNotEmpty()) {
                        fav.delete(Favorites(tokenPrefs.wordId, tokenPrefs.wordName, text))
                        runOnUIThread {
                            viewState.favorite(false)
                        }
                    } else {
                        fav.insert(Favorites(tokenPrefs.wordId, tokenPrefs.wordName, text))
                        runOnUIThread {
                            viewState.favorite(true)
                        }
                    }

                }
            }


        }

    }

    fun speak(translation: String) {
        if (tokenPrefs.locale == "EnUz" || tokenPrefs.locale == "EnRu") {
            viewState.speak(tokenPrefs.wordName)
        } else {
            viewState.speak(translation)

        }
    }


}