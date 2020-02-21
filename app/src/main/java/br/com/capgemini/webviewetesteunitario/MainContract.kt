package br.com.capgemini.webviewetesteunitario

interface MainContract {
    interface ViewImpl {
        fun getFieldNativeText(): String
        fun fillFieldWeb(text: String)
        fun fillFieldNative(text: String)
    }

    interface PresenterImpl {
        fun setView(view: ViewImpl)
        fun updateTextWeb(text: String?)
        fun updateTextNative(text: String?)
        fun responseUpdateTextWeb(text: String)
        fun responseUpdateTextNative(text: String)
        fun getTextFieldWeb(): String
    }

    interface ModelImpl {
        fun getTextModel(): TextModel
        fun setTextNativeModel(value: String)
        fun setTextWebModel(value: String)
    }
}