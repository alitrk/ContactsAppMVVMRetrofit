package com.example.kisileruygulamasi.data.datasource

import android.util.Log
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.example.kisileruygulamasi.retrofit.KisilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class KisilerDataSource (var kdao: KisilerDao){

    suspend fun kaydet(kisi_ad:String,kisi_tel:String) = kdao.kaydet(kisi_ad,kisi_tel)

    suspend fun guncelle(kisi_id:Int,kisi_ad:String,kisi_tel:String) = kdao.guncelle(kisi_id,kisi_ad,kisi_tel)

    suspend fun kisileriYukle() : List<Kisiler> =
        withContext(Dispatchers.IO){
            kdao.kisileriYukle().kisiler
    }

    suspend fun ara(aramaKelimesi:String) : List<Kisiler> =
        withContext(Dispatchers.IO){
            kdao.ara(aramaKelimesi).kisiler
        }

    suspend fun sil(kisi_id:Int) = kdao.sil(kisi_id)
}