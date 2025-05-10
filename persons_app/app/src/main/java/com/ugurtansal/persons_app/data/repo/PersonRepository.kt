package com.ugurtansal.persons_app.data.repo

import android.util.Log
import com.ugurtansal.persons_app.data.dataSource.PersonDataSource

class PersonRepository {
    var personsDataSource= PersonDataSource()

    suspend fun save(personName:String, personGsm:String)= personsDataSource.save(personName, personGsm);

    suspend fun update(personId:Int,personName:String, personGsm:String)=personsDataSource.update(personId,personName, personGsm);

    suspend fun delete(personId: Int)=personsDataSource.delete(personId);

}