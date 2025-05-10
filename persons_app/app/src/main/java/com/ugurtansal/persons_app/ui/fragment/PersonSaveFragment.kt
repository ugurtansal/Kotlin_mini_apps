package com.ugurtansal.persons_app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ugurtansal.persons_app.R
import com.ugurtansal.persons_app.databinding.FragmentPersonSaveBinding
import com.ugurtansal.persons_app.ui.viewModel.PersonSaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PersonSaveFragment : Fragment() {
    private lateinit var binding: FragmentPersonSaveBinding
    private lateinit var viewModel: PersonSaveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentPersonSaveBinding.inflate(inflater, container, false)


        binding.btnSave.setOnClickListener {
            val name= binding.editTextPersonName.text.toString()
            val gsm= binding.editTextPersonGsm.text.toString()

            viewModel.save(name, gsm)
        }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: PersonSaveViewModel by viewModels()
        viewModel= tempViewModel
    }




}