package com.ugurtansal.persons_app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ugurtansal.persons_app.R
import com.ugurtansal.persons_app.databinding.FragmentPersonSaveBinding


class PersonSaveFragment : Fragment() {
    private lateinit var binding: FragmentPersonSaveBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPersonSaveBinding.inflate(inflater, container, false)


        binding.btnSave.setOnClickListener {
            val name= binding.editTextPersonName.text.toString()
            val gsm= binding.editTextPersonGsm.text.toString()

            save(name, gsm)
        }

        return binding.root
    }


    fun save(personName:String, personGsm:String){
        Log.e("Kişi kaydet", "Kişi kaydedildi: $personName, $personGsm", null)
    }


}