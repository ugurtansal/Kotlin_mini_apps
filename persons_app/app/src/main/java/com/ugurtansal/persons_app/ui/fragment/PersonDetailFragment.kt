package com.ugurtansal.persons_app.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ugurtansal.persons_app.R
import com.ugurtansal.persons_app.databinding.FragmentPersonDetailBinding

class PersonDetailFragment : androidx.fragment.app.Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPersonDetailBinding.inflate(inflater, container, false)

        val bundle:PersonDetailFragmentArgs by navArgs() //Gelen veriyi almak için ön hazırlık yaptık
        val person=bundle.kisi //Gelen veriyi aldık
        binding.editTextPersonName.setText(person.kisi_ad)
        binding.editTextPersonGsm.setText(person.kisi_tel)

        binding.btnUpdate.setOnClickListener {
            val personName= binding.editTextPersonName.text.toString()
            val personGsm= binding.editTextPersonGsm.text.toString()

            update(person.kisi_id,personName, personGsm)
        }

        return binding.root
    }

    fun update(personId:Int,personName:String, personGsm:String){
        //Güncelleme işlemi burada yapılacak
        Log.e("Kişi güncelle", "Kişi güncellendi: $personId, $personName, $personGsm", null)
    }


}