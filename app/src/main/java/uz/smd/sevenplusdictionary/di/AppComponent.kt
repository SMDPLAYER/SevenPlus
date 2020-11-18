package uz.smd.sevenplusdictionary.di


import uz.smd.sevenplusdictionary.di.service.base.BaseService
import dagger.Component
import uz.smd.sevenplusdictionary.di.module.*
import uz.smd.sevenplusdictionary.ui.favorites.FavPresenter
import uz.smd.sevenplusdictionary.ui.news.NewsPresenter
import uz.smd.sevenplusdictionary.ui.tasks.presenter.TasksPresenter
import uz.smd.sevenplusdictionary.ui.translation.presenter.TranslationPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    RoomDatabaseModule::class,
    FavDatabaseModule::class,
    RepositoryModule::class,
    NavigationModule::class])

interface AppComponent {
    fun inject(baseService: BaseService)
//    fun inject(presenter: SingUpPresenter)
//    fun inject(presenter: EditChildPresenter)
//    fun inject(presenter: SingInPresenter)
//    fun inject(presenter: AddChildPresenter)
//    fun inject(preferenceFragment: PreferenceFragment)
//    fun inject(profilePresenter: ProfilePresenter)
    fun inject(tasksPresenter: TranslationPresenter)
    fun inject(tasksPresenter: TasksPresenter)
    fun inject(tasksPresenter: NewsPresenter)
    fun inject(tasksPresenter: FavPresenter)
//    fun inject(allergensPresenter: AllergensPresenter)
//    fun inject(loginPresenter: LoginPresenter)
}