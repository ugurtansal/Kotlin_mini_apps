package com.ugurtansal.persons_app.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ugurtansal.persons_app.data.entity.Kisiler

@Database(entities = [Kisiler::class], version = 1)
abstract class Veritabani : RoomDatabase() { //RoomDatabase sınıfından miras alıyoruz
    abstract fun getKisilerDao(): KisilerDao //KisilerDao sınıfını kullanabilmek için bir fonksiyon tanımlıyoruz

}