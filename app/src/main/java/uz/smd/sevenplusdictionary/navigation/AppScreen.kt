package uz.smd.sevenplusdictionary.navigation

import android.content.Context
import ru.terrakok.cicerone.android.support.SupportAppScreen
import android.content.Intent
import androidx.fragment.app.Fragment
import uz.smd.sevenplusdictionary.ui.favorites.FavFragment

import uz.smd.sevenplusdictionary.ui.main.MainActivity
import uz.smd.sevenplusdictionary.ui.news.NewsFragment
import uz.smd.sevenplusdictionary.ui.tasks.fragment.TasksFragment
import uz.smd.sevenplusdictionary.ui.translation.fragment.TranslationFragment


class AppScreen {





    class MainScreen : SupportAppScreen() {
        override fun getActivityIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
    class TasksScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return TasksFragment()
        }
    }
    class TranslationScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return TranslationFragment()
        }
    }
    class NewsScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return NewsFragment()
        }
    }
    class FavScreen : SupportAppScreen() {
        override fun getFragment(): Fragment {
            return FavFragment()
        }
    }

//    class SingUpScreen : SupportAppScreen() {
//        override fun getFragment(): Fragment {
//            return SingUpFragment()
//        }
//    }



}