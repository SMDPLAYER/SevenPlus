package uz.smd.sevenplusdictionary.di.module

import dagger.Module
import dagger.Provides
import uz.smd.sevenplusdictionary.di.service.room.AppDatabase
import uz.smd.sevenplusdictionary.model.repository.BookRepository

@Module
class RepositoryModule {

    @Provides
    fun provideSingUpRepository(api: AppDatabase) = BookRepository(api)


}