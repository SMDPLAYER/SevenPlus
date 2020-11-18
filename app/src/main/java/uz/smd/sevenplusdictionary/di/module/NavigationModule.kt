package uz.smd.sevenplusdictionary.di.module

import dagger.Module
import dagger.Provides
import ru.terrakok.cicerone.Cicerone
import ru.terrakok.cicerone.NavigatorHolder
import uz.smd.sevenplusdictionary.navigation.AppRouter

@Module
class NavigationModule {

    private val cicerone: Cicerone<AppRouter> = Cicerone.create(AppRouter())

    @Provides
    fun provideRouter(): AppRouter = cicerone.router

    @Provides
    fun provideAppNavigatorHolder(): NavigatorHolder = cicerone.navigatorHolder
}
