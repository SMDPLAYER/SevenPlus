package uz.smd.sevenplusdictionary.ui.tasks.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_dictionary.*
import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.di.service.room.entity.Word
import uz.smd.sevenplusdictionary.ui.base.fragment.MvpAppCompatFragmentX
import uz.smd.sevenplusdictionary.ui.tasks.adapter.DictionaryAdapter
import uz.smd.sevenplusdictionary.ui.tasks.presenter.TasksPresenter
import uz.smd.sevenplusdictionary.ui.tasks.view.TasksView
import uz.smd.sevenplusdictionary.utils.runLayoutAnimation


class TasksFragment : MvpAppCompatFragmentX(R.layout.fragment_dictionary), TasksView {

    private val adapter =  DictionaryAdapter()
    @InjectPresenter
    lateinit var presenter: TasksPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        list.adapter = adapter
        clickListener()


    }


    private fun clickListener() {
        adapter.setListenerGetPos {
          presenter.clickWord(it)
        }

        btnEnRu.setOnClickListener { presenter.changeLocale("EnRu") }
        btnEnUz.setOnClickListener { presenter.changeLocale("EnUz") }
        btnRuEn.setOnClickListener { presenter.changeLocale("RuEn") }
        btnUzEn.setOnClickListener { presenter.changeLocale("UzEn") }

        search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
            override fun afterTextChanged(editable: Editable) {
                if (editable.toString().isNotEmpty()) {
                    val alpha= "$editable%"
                    presenter.loadWithQuery(alpha)
                }
            }
            override fun onTextChanged(charSequence: CharSequence, i: Int, i2: Int, i3: Int) {}
        })
    }

    override fun showTask(listTasksDay: List<Word>) {
        runLayoutAnimation(list)
        adapter.setTasksDay(listTasksDay)


    }

    override fun showLoader(isTrue: Boolean) {
        if (isTrue)
            loaderProgress.visibility=View.VISIBLE
        else
        loaderProgress.visibility=View.GONE

    }

    override fun changeColorText(locale: String) {
        when(locale){
            "EnRu"->{
                btnEnRu.isClickable=false
                btnUzEn.isClickable=true
                btnRuEn.isClickable=true
                btnEnUz.isClickable=true
                textEnRu.setTextColor(resources.getColor(R.color.colorSelected))
                textEngUz.setTextColor(resources.getColor(R.color.colorUnselected))
                textRuEn.setTextColor(resources.getColor(R.color.colorUnselected))
                textUzEn.setTextColor(resources.getColor(R.color.colorUnselected))
            }
            "UzEn"->{
                btnEnRu.isClickable=true
                btnUzEn.isClickable=false
                btnRuEn.isClickable=true
                btnEnUz.isClickable=true
                textEnRu.setTextColor(resources.getColor(R.color.colorUnselected))
                textEngUz.setTextColor(resources.getColor(R.color.colorUnselected))
                textRuEn.setTextColor(resources.getColor(R.color.colorUnselected))
                textUzEn.setTextColor(resources.getColor(R.color.colorSelected))
            }
            "RuEn"->{
                btnEnRu.isClickable=true
                btnUzEn.isClickable=true
                btnRuEn.isClickable=false
                btnEnUz.isClickable=true
                textEnRu.setTextColor(resources.getColor(R.color.colorUnselected))
                textEngUz.setTextColor(resources.getColor(R.color.colorUnselected))
                textRuEn.setTextColor(resources.getColor(R.color.colorSelected))
                textUzEn.setTextColor(resources.getColor(R.color.colorUnselected))
            }
            "EnUz"->{
                btnEnRu.isClickable=true
                btnUzEn.isClickable=true
                btnRuEn.isClickable=true
                btnEnUz.isClickable=false
                textEnRu.setTextColor(resources.getColor(R.color.colorUnselected))
                textEngUz.setTextColor(resources.getColor(R.color.colorSelected))
                textRuEn.setTextColor(resources.getColor(R.color.colorUnselected))
                textUzEn.setTextColor(resources.getColor(R.color.colorUnselected))
            }
        }
    }


}

