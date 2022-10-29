package com.example.kisileruygulamasi.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiKayitBinding
import com.example.kisileruygulamasi.ui.viewmodel.KisiKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class KisiKayitFragment : Fragment() {
    private lateinit var tasarim:FragmentKisiKayitBinding
    private lateinit var viewModel: KisiKayitViewModel
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        tasarim = DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_kayit, container, false)
        tasarim.kisiKayitFragment = this
        tasarim.kisiKayitToolbarBaslik = "Kişi Kayıt"

        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel:KisiKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun buttonKaydet(kisi_ad:String,kisi_tel:String){
        viewModel.kaydet(kisi_ad,kisi_tel)
    }
}