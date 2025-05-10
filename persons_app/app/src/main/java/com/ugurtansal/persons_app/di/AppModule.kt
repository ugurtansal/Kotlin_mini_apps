package com.ugurtansal.persons_app.di

import com.ugurtansal.persons_app.data.dataSource.PersonDataSource
import com.ugurtansal.persons_app.data.repo.PersonRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun providePersonRepository(personDataSource: PersonDataSource): PersonRepository{
        //Bu classtan 3 viewmodel için tek bir tane oluşturulacak
        //Bu sayede her bir viewmodel için ayrı ayrı oluşturulmasına gerek kalmayacak
        //Tek bir tane oluşturulacak ve inject edilecek
        //İsminin "provide" ile başlaması zorunlu değil fakat bu şekilde yazılması öneriliyor
        return PersonRepository(personDataSource)
    }

    @Provides
    @Singleton
    fun providePersonDataSource(): PersonDataSource{
        return PersonDataSource()
    }
}