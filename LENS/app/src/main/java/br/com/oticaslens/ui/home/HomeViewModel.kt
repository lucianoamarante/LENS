package br.com.oticaslens.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Aqui estamos no Fragmeto Home"
    }
    val text: LiveData<String> = _text
}