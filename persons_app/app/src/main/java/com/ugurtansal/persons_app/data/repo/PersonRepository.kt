package com.ugurtansal.persons_app.data.repo

import android.util.Log
import com.ugurtansal.persons_app.data.dataSource.PersonDataSource
import com.ugurtansal.persons_app.data.entity.Kisiler

class PersonRepository (var personsDataSource: PersonDataSource) {
    //var personsDataSource= PersonDataSource()

    suspend fun save(personName:String, personGsm:String)= personsDataSource.save(personName, personGsm);

    suspend fun update(personId:Int,personName:String, personGsm:String)=personsDataSource.update(personId,personName, personGsm);

    suspend fun delete(personId: Int)=personsDataSource.delete(personId);

    suspend fun loadPeople(): List<Kisiler> =personsDataSource.loadPeople();

    suspend fun search(searchedWord: String): List<Kisiler> =personsDataSource.search(searchedWord)

}