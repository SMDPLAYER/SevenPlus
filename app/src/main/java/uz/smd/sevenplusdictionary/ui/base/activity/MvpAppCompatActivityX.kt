package uz.smd.sevenplusdictionary.ui.base.activity

import android.content.Context
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.arellomobile.mvp.MvpDelegate
import uz.smd.sevenplusdictionary.utils.LocaleHelper

open class MvpAppCompatActivityX : AppCompatActivity() {

    private var mMvpDelegate: MvpDelegate<MvpAppCompatActivityX> = MvpDelegate(this)

    override fun attachBaseContext(newBase: Context?) {
        if (newBase == null) {
            super.attachBaseContext(newBase)
        } else {
            val newBase = LocaleHelper.onAttach(newBase)
            super.attachBaseContext(newBase)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mMvpDelegate.onCreate(savedInstanceState)
    }

    override fun onStart() {
        super.onStart()

        mMvpDelegate.onAttach()
    }

    override fun onResume() {
        super.onResume()

        mMvpDelegate.onAttach()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        mMvpDelegate.onSaveInstanceState(outState)
        mMvpDelegate.onDetach()
    }

    override fun onStop() {
        super.onStop()

        mMvpDelegate.onDetach()
    }

    override fun onDestroy() {
        super.onDestroy()

        mMvpDelegate.onDestroyView()

        if (isFinishing) {
            mMvpDelegate.onDestroy()
        }
    }

    override fun applyOverrideConfiguration(overrideConfiguration: Configuration) {
        super.applyOverrideConfiguration(baseContext.resources.configuration)
    }


//    fun setOnBackPressedListener(listener: BackPressedListener) {
//        backPressedListener = listener
//    }

}