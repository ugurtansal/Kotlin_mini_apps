package com.ugurtansal.persons_app.utils

import android.view.View
import androidx.navigation.Navigation
import com.ugurtansal.persons_app.R

fun Navigation.pass(it: View, id:Int){

    findNavController(it).navigate(id);

}