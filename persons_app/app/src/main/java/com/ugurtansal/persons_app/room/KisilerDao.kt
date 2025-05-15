package com.ugurtansal.persons_app.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.ugurtansal.persons_app.data.entity.Kisiler

@Dao
interface KisilerDao { //DAO=Database Access Object

    @Query("SELECT * FROM kisiler") //kisi tablosundaki tüm verileri getir
    suspend fun loadPeople(): List<Kisiler> //suspend function ile arka planda çalıştırıyoruz

    @Insert
    suspend fun save(kisi: Kisiler) //Kişi kaydetme işlemi için bir fonksiyon tanımlıyoruz

    @Update
    suspend fun update(kisi: Kisiler) //Kişi güncelleme işlemi için bir fonksiyon tanımlıyoruz

    @Delete
    suspend fun delete(kisi: Kisiler)

    @Query("SELECT * FROM kisiler WHERE kisi_ad LIKE '%' || :searchedWord ||'%'")
    suspend fun search(searchedWord: String): List<Kisiler> //Kişi arama işlemi için bir fonksiyon tanımlıyoruz
}