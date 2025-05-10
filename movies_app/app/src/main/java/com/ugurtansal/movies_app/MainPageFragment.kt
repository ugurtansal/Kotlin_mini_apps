package com.ugurtansal.movies_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ugurtansal.movies_app.databinding.FragmentMainPageBinding


class MainPageFragment : Fragment() {

    private lateinit var binding: FragmentMainPageBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         binding=FragmentMainPageBinding.inflate(inflater, container, false)

        val moviesList = ArrayList<Filmler>()
        val f1 = Filmler(1,"Django","django",24)
        val f2 = Filmler(2,"Interstellar","interstellar",32)
        val f3 = Filmler(3,"Inception","inception",16)
        val f4 = Filmler(4,"The Hateful Eight","thehatefuleight",28)
        val f5 = Filmler(5,"The Pianist","thepianist",18)
        val f6 = Filmler(6,"Anadoluda","anadoluda",10)
        moviesList.add(f1)
        moviesList.add(f2)
        moviesList.add(f3)
        moviesList.add(f4)
        moviesList.add(f5)
        moviesList.add(f6)

        val moviesAdapter=MoviesAdapter(requireContext(),moviesList)
        binding.moviesRv.adapter=moviesAdapter

        binding.moviesRv.layoutManager= StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)

        return binding.root
    }


}