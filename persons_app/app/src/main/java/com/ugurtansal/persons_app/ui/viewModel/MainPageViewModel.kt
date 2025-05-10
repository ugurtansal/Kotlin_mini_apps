package com.ugurtansal.persons_app.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ugurtansal.persons_app.data.repo.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainPageViewModel : ViewModel(){
    var personsRepository=PersonRepository()

    fun delete(personId: Int){
        CoroutineScope(Dispatchers.Main).launch { //suspend olmasını engellemek için
            personsRepository.delete(personId)
        }
    }




}