package com.ugurtansal.persons_app.ui.fragment


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.ugurtansal.persons_app.R
import com.ugurtansal.persons_app.databinding.FragmentPersonDetailBinding
import com.ugurtansal.persons_app.ui.viewModel.PersonDetailViewModel
import com.ugurtansal.persons_app.ui.viewModel.PersonSaveViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class PersonDetailFragment : androidx.fragment.app.Fragment() {
    private lateinit var binding: FragmentPersonDetailBinding
    private lateinit var viewModel: PersonDetailViewModel

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

            viewModel.update(person.kisi_id,personName, personGsm)
        }

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonDetailViewModel by viewModels()
        viewModel= tempViewModel
    }



}