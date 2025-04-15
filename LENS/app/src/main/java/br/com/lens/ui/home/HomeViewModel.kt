package br.com.lens.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "..:: Esse é o fragmento de Home ::.."
    }
    val text: LiveData<String> = _text
}