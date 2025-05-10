package com.ugurtansal.persons_app.ui.adapter

import android.R
import android.app.Person
import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.ugurtansal.persons_app.data.entity.Kisiler
import com.ugurtansal.persons_app.databinding.CardDesignBinding
import com.ugurtansal.persons_app.databinding.FragmentMainPageBinding
import com.ugurtansal.persons_app.ui.fragment.MainPageFragmentDirections
import com.ugurtansal.persons_app.ui.viewModel.MainPageViewModel
import com.ugurtansal.persons_app.utils.pass

class PersonAdapter(var mContext: Context,var personsList: List<Kisiler>,var viewModel: MainPageViewModel)
    : RecyclerView.Adapter<PersonAdapter.CardDesignHolder>()
{

    inner class CardDesignHolder (var design: CardDesignBinding): RecyclerView.ViewHolder(design.root)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDesignHolder {

        val design= CardDesignBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardDesignHolder(design)
    }

    override fun onBindViewHolder(holder: CardDesignHolder, position: Int) {

        val person= personsList.get(position) //0,1,2
        val t=holder.design
        t.personName.text= person.kisi_ad
        t.personGsm.text= person.kisi_tel

        t.cardViewRow.setOnClickListener {
            val pass= MainPageFragmentDirections.personDetailPass(kisi = person)
            //Navigation.findNavController(it).navigate(pass) //We create Extension function in utils (overload) and use it down
            Navigation.pass(it,pass)
        }

        t.imageViewDelete.setOnClickListener {
            Snackbar.make(it,"${person.kisi_ad} silinsin?", Snackbar.LENGTH_SHORT)
                .setAction("Evet") {

                    viewModel.delete(person.kisi_id);
                   // Snackbar.make(it,"${person.kisi_ad} silindi", Snackbar.LENGTH_SHORT).show()
                }.show()

        }
    }

    override fun getItemCount(): Int {

        return personsList.size
    }



}