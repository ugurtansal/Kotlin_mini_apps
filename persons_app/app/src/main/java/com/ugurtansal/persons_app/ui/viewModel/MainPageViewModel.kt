package com.ugurtansal.persons_app.ui.viewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurtansal.persons_app.data.entity.Kisiler
import com.ugurtansal.persons_app.data.repo.PersonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainPageViewModel @Inject constructor ( var personsRepository:PersonRepository) : ViewModel(){
   // var personsRepository=PersonRepository() //Dependency Injection ile inject ediliyor
    val peopleList= MutableLiveData<List<Kisiler>>()

    init {
        loadPeople()
    }

    fun delete(personId: Int){
        CoroutineScope(Dispatchers.Main).launch { //suspend olmasını engellemek için
            personsRepository.delete(personId)
            loadPeople()
        }
    }

     fun loadPeople(){
        CoroutineScope(Dispatchers.Main).launch {
            peopleList.value=personsRepository.loadPeople(); //Trigger-Tetikleme
        }
    }

     fun search(searchedWord: String){
        CoroutineScope(Dispatchers.Main).launch {
            peopleList.value=personsRepository.search(searchedWord); //Trigger-Tetikleme
        }
     }




}