package br.com.lens.ui.gallery

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "..:: Aqui esta a Galeria de Fotos ::.."
    }
    val text: LiveData<String> = _text
}