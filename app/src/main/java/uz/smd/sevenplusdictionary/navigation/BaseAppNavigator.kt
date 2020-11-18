package uz.smd.sevenplusdictionary.navigation

import ru.terrakok.cicerone.android.support.SupportAppNavigator
import uz.smd.sevenplusdictionary.ui.base.activity.MvpAppCompatActivityX

abstract class BaseAppNavigator(
    private val activity: MvpAppCompatActivityX,
    private val localContainerId: Int
) : SupportAppNavigator(activity, localContainerId) {

}