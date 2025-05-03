package br.com.oticaslens.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Dentro da Galeria, vamos ver as Fotos!"
    }
    val text: LiveData<String> = _text
}