package uz.smd.sevenplusdictionary.ui.favorites

import android.os.Bundle

import android.view.View


import com.arellomobile.mvp.presenter.InjectPresenter
import kotlinx.android.synthetic.main.fragment_fav.*
import uz.smd.sevenplusdictionary.R
import uz.smd.sevenplusdictionary.di.service.room.entity.Favorites

import uz.smd.sevenplusdictionary.ui.base.fragment.MvpAppCompatFragmentX



class FavFragment : MvpAppCompatFragmentX(R.layout.fragment_fav), FavView {

    private val adapter =  FavAdapter()
//    private val adapter =  ContactAdapter()
    @InjectPresenter
    lateinit var presenter: FavPresenter


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        listFav.adapter = adapter
        clickListener()


    }


    private fun clickListener() {


    }

    override fun showTask(listTasksDay: List<Favorites>) {

        adapter.setTasksDay(listTasksDay)
//        adapter.submitList(listTasksDay)

    }

    override fun showLoader(isTrue: Boolean) {
//        if (isTrue)
//            loaderProgress.visibility=View.VISIBLE
//        else
//        loaderProgress.visibility=View.GONE

    }


}

