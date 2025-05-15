package com.ugurtansal.persons_app.data.dataSource

import android.util.Log
import com.ugurtansal.persons_app.data.entity.Kisiler
import com.ugurtansal.persons_app.room.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource(var kisiDao: KisilerDao) {

    suspend fun save(personName:String, personGsm:String){
        val newPerson= Kisiler(0, personName, personGsm)
        kisiDao.save(newPerson) //Kişi kaydetme işlemi
        //Log.e("Kişi kaydet", "Kişi kaydedildi: $personName, $personGsm", null)
    }

    suspend fun update(personId:Int,personName:String, personGsm:String){
        //Suspend yapısı asenkron çalışmasını sağlar
        val updatedPerson= Kisiler(personId, personName, personGsm)
        kisiDao.update(updatedPerson) //Kişi güncelleme işlemi
        //Log.e("Kişi güncelle", "Kişi güncellendi: $personId, $personName, $personGsm", null)
    }

    suspend fun delete(personId: Int){
        val deletedPerson= Kisiler(personId,"","");
        kisiDao.delete(deletedPerson);
       // Log.e("Kişi sil", "Kişi silindi: $personId", null)
    }

    suspend fun loadPeople(): List<Kisiler> = withContext(Dispatchers.IO){

        return@withContext kisiDao.loadPeople()

    }

    suspend fun search(searchedWord: String): List<Kisiler> = withContext(Dispatchers.IO){

        return@withContext kisiDao.search(searchedWord);

    }

}