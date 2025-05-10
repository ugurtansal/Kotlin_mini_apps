package com.ugurtansal.persons_app.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ugurtansal.persons_app.R
import com.ugurtansal.persons_app.data.entity.Kisiler
import com.ugurtansal.persons_app.databinding.FragmentMainPageBinding
import com.ugurtansal.persons_app.ui.adapter.PersonAdapter
import com.ugurtansal.persons_app.ui.viewModel.MainPageViewModel
import com.ugurtansal.persons_app.ui.viewModel.PersonSaveViewModel
import com.ugurtansal.persons_app.utils.pass
import dagger.hilt.android.AndroidEntryPoint
import kotlin.getValue

@AndroidEntryPoint
class MainPageFragment : Fragment() {
    private lateinit var binding: FragmentMainPageBinding
    private lateinit var viewModel: MainPageViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentMainPageBinding.inflate(inflater, container, false)


        binding.fab.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.personSavePass); //We used Extension function in utils and use it down
            Navigation.pass(it,R.id.personSavePass)
        }


       viewModel.peopleList.observe(viewLifecycleOwner){
       //Dinleme
           val personAdapter= PersonAdapter(requireContext(), it, viewModel);
           binding.personRv.adapter= personAdapter;
       }






        binding.personRv.layoutManager= LinearLayoutManager(requireContext()) //Alt alta görünmesi için LinearLayoutManager kullandık
//        binding.personRv.layoutManager=
//            StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL) //Instagram hikaye tarzı görünüm için StaggeredGridLayoutManager kullandık , 1 tane görünecek ve yana doğru kayacak


        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(query: String): Boolean {
                //Arama butonuna tıklandığında çalışır
                viewModel.search(query)
                return false
            }

            override fun onQueryTextChange(newText: String): Boolean {
                //Harf girdikçe çalışır
                viewModel.search(newText)
                return false
            }
        })

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: MainPageViewModel by viewModels()
        viewModel= tempViewModel
    }




    override fun onResume() {
        super.onResume();
       viewModel.loadPeople();
    }

}
