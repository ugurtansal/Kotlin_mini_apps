package com.ugurtansal.persons_app.ui.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.ugurtansal.persons_app.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PersonDetailViewModel @Inject constructor (var personsRepository:PersonRepository): ViewModel() {
    //var personsRepository=PersonRepository() //Dependency Injection ile inject ediliyor

    fun update(personId:Int,personName:String, personGsm:String){
        CoroutineScope(Dispatchers.Main).launch { //suspend olmasını engellemek için
            personsRepository.update(personId, personName, personGsm)
        }
    }

}