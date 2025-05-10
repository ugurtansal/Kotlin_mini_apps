package com.ugurtansal.movies_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.ugurtansal.movies_app.databinding.FragmentDetailBinding


class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentDetailBinding.inflate(inflater, container, false)

        val bundle: DetailFragmentArgs by navArgs()
        val movie=bundle.movieObject;

        binding.toolbarDetail.title=movie.ad
        binding.tvPrice.text="${movie.fiyat} ₺"
        binding.ivMovie.setImageResource(resources.getIdentifier(movie.resim,"drawable",requireContext().packageName))


        return binding.root
    }


}