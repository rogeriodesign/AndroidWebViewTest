package br.com.capgemini.webviewetesteunitario

class JavascriptInterface(private val model: WebViewModel) {
    @android.webkit.JavascriptInterface
    fun updateTextWeb(text: String?) {
        text?.let{
            model.textFieldWeb.postValue(text)
        }
    }
}