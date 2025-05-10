package com.ugurtansal.persons_app.data.dataSource

import android.util.Log

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


}