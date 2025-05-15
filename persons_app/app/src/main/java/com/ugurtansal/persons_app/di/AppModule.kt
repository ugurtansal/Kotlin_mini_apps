package com.ugurtansal.persons_app.di

import android.content.Context
import androidx.room.Room
import com.ugurtansal.persons_app.data.dataSource.PersonDataSource
import com.ugurtansal.persons_app.data.repo.PersonRepository
import com.ugurtansal.persons_app.room.KisilerDao
import com.ugurtansal.persons_app.room.Veritabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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
    fun providePersonDataSource(kisilerDao: KisilerDao): PersonDataSource{
        return PersonDataSource(kisilerDao)
    }

    @Provides
    @Singleton                      //Hilt kütüphanesi sayesinde oluyor
    fun provideKisilerDao(@ApplicationContext context: Context): KisilerDao{
        val database= Room.databaseBuilder(context, Veritabani::class.java,"persons_app_db.db").createFromAsset("persons_app_db.db").build()

        return database.getKisilerDao()
    }
}