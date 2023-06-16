package com.example.sawithub.ui.riwayatKonsul

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RiwayatKonsulViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This Feature is Coming Soon :)"
    }
    val text: LiveData<String> = _text
}