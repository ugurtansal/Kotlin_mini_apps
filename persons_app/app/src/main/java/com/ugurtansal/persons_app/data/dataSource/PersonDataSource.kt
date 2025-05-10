package com.ugurtansal.persons_app.data.dataSource

import android.util.Log
import com.ugurtansal.persons_app.data.entity.Kisiler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource {

    suspend fun save(personName:String, personGsm:String){
        Log.e("Kişi kaydet", "Kişi kaydedildi: $personName, $personGsm", null)
    }

    suspend fun update(personId:Int,personName:String, personGsm:String){
        //Suspend yapısı asenkron çalışmasını sağlar
        Log.e("Kişi güncelle", "Kişi güncellendi: $personId, $personName, $personGsm", null)
    }

    suspend fun delete(personId: Int){
        Log.e("Kişi sil", "Kişi silindi: $personId", null)
    }

    suspend fun loadPeople(): List<Kisiler> = withContext(Dispatchers.IO){
        val personsList= ArrayList<Kisiler>()
        val person1= Kisiler(1, "Ali", "123456789")
        val person2= Kisiler(2, "Ayşe", "987654321")
        val person3= Kisiler(3, "Mehmet", "456789123")

        personsList.add(person1)
        personsList.add(person2)
        personsList.add(person3)
        return@withContext personsList

    }

    suspend fun search(searchedWord: String): List<Kisiler> = withContext(Dispatchers.IO){
        val personsList= ArrayList<Kisiler>()
        val person1= Kisiler(1, "Ali", "123456789")

        personsList.add(person1)

        return@withContext personsList

    }

}