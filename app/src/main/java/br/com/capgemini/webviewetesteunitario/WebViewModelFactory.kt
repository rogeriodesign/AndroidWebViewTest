package br.com.capgemini.webviewetesteunitario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class WebViewModelFactory: ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor().newInstance()
    }
}