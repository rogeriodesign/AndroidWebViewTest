package br.com.capgemini.webviewetesteunitario

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


inline fun <reified VM : ViewModel> AppCompatActivity.getViewModel() =
    ViewModelProvider(this, WebViewModelFactory()).get(VM::class.java)
