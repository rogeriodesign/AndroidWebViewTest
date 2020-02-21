package br.com.capgemini.webviewetesteunitario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class WebViewModel: ViewModel() {

    val textFieldWeb = MutableLiveData<String>()

    fun getTextWeb(): LiveData<String> {
        return textFieldWeb
    }
}