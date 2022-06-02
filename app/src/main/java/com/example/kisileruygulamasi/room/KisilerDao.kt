package com.example.kisileruygulamasi.room

import androidx.room.*
import com.example.kisileruygulamasi.entity.Kisiler

@Dao
interface KisilerDao {
    @Query("SELECT * FROM kisiler")
    suspend fun tumKisiler() : List<Kisiler>//ınterface taslak fonk ister bu da bir taslak fonk nasıl anlıcak query ekleyınce
    @Insert
    suspend fun  kisiEkle(kisi: Kisiler)

    @Update
    suspend fun  kisiGuncelle(kisi: Kisiler)


    @Delete
    suspend fun  kisiSil(kisi: Kisiler)


    @Query("SELECT * FROM kisiler WHERE kisi_ad like '%'  ||  :aramaKelimesi ||  '%'")
    suspend fun kisiArama(aramaKelimesi:String) :List<Kisiler>






}