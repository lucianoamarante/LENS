package com.example.moraesworld.ui.oferta

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OfertaViewModel : ViewModel() {
    // TODO: Implement the ViewModel


    private val _text = MutableLiveData<String>().apply {
        value = "Procurando a menhor Oferta!!!"
    }
    val text: LiveData<String> = _text
}