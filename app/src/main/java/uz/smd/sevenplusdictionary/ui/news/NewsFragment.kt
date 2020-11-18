package uz.smd.sevenplusdictionary.ui.news

import android.os.Bundle
import android.view.View
import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_dictionary.*
import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.ui.base.fragment.MvpAppCompatFragmentX



class NewsFragment : MvpAppCompatFragmentX(R.layout.fragment_main), NewsView {

    @InjectPresenter
    lateinit var presenter: NewsPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickListener()


    }


    private fun clickListener() {

    }



    override fun showLoader(isTrue: Boolean) {
        if (isTrue)
            loaderProgress.visibility=View.VISIBLE
        else
        loaderProgress.visibility=View.GONE

    }


}

