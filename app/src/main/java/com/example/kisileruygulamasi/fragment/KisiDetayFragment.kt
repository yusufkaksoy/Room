package com.example.kisileruygulamasi.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.databinding.FragmentKisiDetayBinding
import com.example.kisileruygulamasi.viewmodel.KisiDetayFragmentViewModel
import com.example.kisileruygulamasi.viewmodel.KisiDetayVMF
import com.example.kisileruygulamasi.viewmodel.KisiKayitFragmentViewModel
import com.example.kisileruygulamasi.viewmodel.KisiKayitVMF


class KisiDetayFragment : Fragment() {
private lateinit var tasarim:FragmentKisiDetayBinding
private lateinit var viewModel : KisiDetayFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tasarim= DataBindingUtil.inflate(inflater,R.layout.fragment_kisi_detay,container,false)
        tasarim.kisiDetayFragment=this//yetkilendirme
        tasarim.kisiDetayToolbarBaslik="Kişi Detay"//baslik değiştirme



        val bundle:KisiDetayFragmentArgs by navArgs()//by özelliği aktarmayı sağlar(Delegate)
        val gelenKisi = bundle.kisi

        tasarim.kisiNesnesi = gelenKisi

        //tasarim.editTextKisiAd.setText(gelenKisi.kisi_ad)
        //tasarim.editTextKisiTel.setText(gelenKisi.kisi_tel)


        return tasarim.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel : KisiDetayFragmentViewModel by viewModels(){
            KisiDetayVMF(requireActivity().application)

        }
        viewModel = tempViewModel
    }

    fun buttonGuncelleTikla(kisi_id:Int,kisi_ad:String,kisi_tel:String){

        viewModel.guncelle(kisi_id,kisi_ad,kisi_tel)



    }


}