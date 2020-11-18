package uz.smd.sevenplusdictionary.ui.main

import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.Screen
import uz.smd.sevenplusdictionary.navigation.AppScreen
import uz.smd.sevenplusdictionary.ui.base.presenter.BasePresenter
import uz.smd.sevenplusdictionary.utils.runOnWorkerThread

class MainPresenter : BasePresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(AppScreen.NewsScreen())
        load()
    }
fun load(){
    runOnWorkerThread {
          category.getCategory(1)
            tokenPrefs.isFirst=0
    }

}
    fun setNavigator(navigator: Navigator) {
        navigatorHolder.removeNavigator()
        navigatorHolder.setNavigator(navigator)
    }

    fun navigate(tasksScreen: Screen) {
        router.replaceScreen(tasksScreen)
    }
    //    private fun navigateTo(screen: Screen) {
//        router.navigateTo(screen)
//    }
}