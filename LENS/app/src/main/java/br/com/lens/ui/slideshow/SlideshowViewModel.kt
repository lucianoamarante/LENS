package br.com.lens.ui.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SlideshowViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "..:: Você esta dentro do Fragmento para Vídeo ::.."
    }
    val text: LiveData<String> = _text
}