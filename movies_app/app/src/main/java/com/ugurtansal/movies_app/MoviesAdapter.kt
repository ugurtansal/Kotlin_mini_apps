package com.ugurtansal.movies_app

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ugurtansal.movies_app.databinding.CardDesignBinding
import com.ugurtansal.movies_app.databinding.FragmentMainPageBinding

class MoviesAdapter(var mContext: Context, var moviesList:List<Filmler>): RecyclerView.Adapter<MoviesAdapter.cardDesignHold>() {

    inner class cardDesignHold(var design: CardDesignBinding) : RecyclerView.ViewHolder(design.root){


    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): cardDesignHold {
       var binding=CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)

        return cardDesignHold(binding)
    }

    override fun onBindViewHolder(
        holder: cardDesignHold,
        position: Int
    ) {

        val movie=moviesList.get(position)
        val t=holder.design
        t.textViewPrice.text="${movie.fiyat} TL"
        t.imageViewMovie.setImageResource(mContext.resources.getIdentifier(movie.resim,"drawable",mContext.packageName))

        t.buttonCart.setOnClickListener {
            Snackbar.make(it,"${movie.ad} added to cart",Snackbar.LENGTH_SHORT).show()
        }

        t.cardViewMovie.setOnClickListener {
            val pass= MainPageFragmentDirections.detilsPass(movieObject = movie)
            Navigation.findNavController(it).navigate(pass)
        }

    }

    override fun getItemCount(): Int {
      return moviesList.size;
    }


}