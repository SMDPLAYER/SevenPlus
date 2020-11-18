package uz.smd.sevenplusdictionary.ui.translation.fragment

import android.os.Bundle
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.OnInitListener
import android.view.View
import android.widget.Toast

import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_translation.*
import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import uz.smd.sevenplusdictionary.ui.base.fragment.MvpAppCompatFragmentX
import uz.smd.sevenplusdictionary.ui.translation.adapter.TranslationAdapter
import uz.smd.sevenplusdictionary.ui.translation.presenter.TranslationPresenter
import uz.smd.sevenplusdictionary.ui.translation.view.TranslationView
import java.util.*


class TranslationFragment : MvpAppCompatFragmentX(R.layout.fragment_translation), TranslationView,
    OnInitListener {
    private val adapter =  TranslationAdapter()
    lateinit var  tts: TextToSpeech
    @InjectPresenter
    lateinit var presenter: TranslationPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
load()
        list_translation.adapter = adapter
        clickListener()



    }
    fun load(){
        //        InitializeAds();
        tts = TextToSpeech(requireContext(), this)
        tts.setPitch(1f)
        tts.setSpeechRate(1f)
    }

    private fun clickListener() {
        adapter.setListenerGetPos {
            presenter.clickWord(it)
        }
        iconFav.setOnClickListener {
            presenter.addFav(translated_word.text.toString())
        }
        btnSpeak.setOnClickListener {
            presenter.speak(translated_word.text.toString())
        }
    }

//    override fun showTask(
//        listTasksDay: MutableList<TranslatedWords>,
//        wordName: String,
//        transcription: String
//    ) {
////        translated_word.text= listTasksDay.first().word.name!!.capitalize()
////        translated_category.text= listTasksDay.first().category
////        translated_transcription.text= transcription!!.capitalize()
////        translating_word.text= wordName!!.capitalize()
//
////        adapter.submitList(listTasksDay)
//
//    }

    override fun showTask(listTasksDay: List<Word>) {

        adapter.setTasksDay(listTasksDay)
    }



    override fun showTask(word: Word) {
        translated_word.text= word.name!!.capitalize()
    }

    override fun favorite(isFav: Boolean) {
        if (isFav)
        iconFav.setImageResource(R.drawable.favoriteicn)
        else
            iconFav.setImageResource(R.drawable.agendaicn)
    }

    override fun speak(speaking: String) {

        tts.speak(speaking, 0, null)
    }

    override fun showCategory(s: String?) {
        translated_category.text= s
    }

    override fun showFromLocal(wordName: String, transcription: String) {
        translated_transcription.text= transcription.capitalize()
        translating_word.text= wordName.capitalize()
    }

    override fun onInit(k: Int) {
        var i=k
        if (i == 0) {
            i = tts.setLanguage(Locale.US)
            if (i == -1 || i == -2) {
                Toast.makeText(
                    requireContext(),
                    "This Language is not supported",
                    Toast.LENGTH_SHORT
                ).show()
                return
            } else {
                speak("")
                return
            }
        }
        Toast.makeText(requireContext(), "Initialization Failed!", Toast.LENGTH_SHORT).show()
    }


}

