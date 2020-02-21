package br.com.capgemini.webviewetesteunitario

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), MainContract.ViewImpl {
    private val presenter = Presenter()
    private lateinit var model: WebViewModel

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.AppTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter.setView(this)
        setViewModel()
        setWebView()
        setBtNative()
    }

    override fun onDestroy() {
        webview.removeJavascriptInterface("javascript_object")
        super.onDestroy()
    }

    private fun setViewModel() {
        model = getViewModel<WebViewModel>()
        model.getTextWeb().observe(this, Observer<String> { text ->
            Log.i("recuperou o valor", text)
            presenter.updateTextWeb(text)
        })
    }

    private fun setWebView() {
        webview.loadUrl("file:///android_asset/home.html")
        webview.settings.javaScriptEnabled = true
        webview.addJavascriptInterface(JavascriptInterface(model), "javascript_object")
        webview.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                val text = presenter.getTextFieldWeb()
                fillFieldWeb(text)
                super.onPageStarted(view, url, favicon)
            }
        }
    }

    private fun setBtNative() = buttonNative.setOnClickListener {
        presenter.updateTextNative(getFieldNativeText())
    }

    override fun getFieldNativeText(): String = editTextNative.text.toString()

    override fun fillFieldWeb(text: String) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            webview.evaluateJavascript("fillFieldWeb(\"$text\")", null)
        } else {
            webview.loadUrl("javascript:fillFieldWeb(\"$text\")")
        }
    }

    override fun fillFieldNative(text: String) {
        editTextNative.setText(text)
    }
}
