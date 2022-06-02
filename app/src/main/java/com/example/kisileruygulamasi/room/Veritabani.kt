package com.example.kisileruygulamasi.room

import android.content.Context
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.kisileruygulamasi.entity.Kisiler

@Database(entities = [Kisiler::class],version = 1) // iki sınıfın varsa virgül koy sonra devam et
abstract  class Veritabani:RoomDatabase() {//kalitım yoluyola roomdatabe özelliği eklendi
    abstract  fun kisilerDao() : KisilerDao
    companion object{
        var INSTANCE: Veritabani? = null

        fun veritabaniErisim(context: Context): Veritabani? {
            if (INSTANCE==null){

                synchronized(Veritabani::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        Veritabani::class.java,
                        "rehber1.sqlite").createFromAsset("rehber1.sqlite").build()
                }

            }
            return INSTANCE
        }

    }
}