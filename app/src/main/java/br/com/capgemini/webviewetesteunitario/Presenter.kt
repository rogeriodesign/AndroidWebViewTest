package br.com.capgemini.webviewetesteunitario


class Presenter: MainContract.PresenterImpl {
    private val model: MainContract.ModelImpl = Repository(this)
    private lateinit var viewMain: MainContract.ViewImpl

    override fun setView(view: MainContract.ViewImpl) {
        viewMain = view
    }

    override fun getTextFieldWeb() = model.getTextModel().textFieldWeb

    override fun responseUpdateTextWeb(text: String) {
        viewMain.fillFieldNative(text)
    }

    override fun responseUpdateTextNative(text: String) {
        model.setTextWebModel(text)
        viewMain.fillFieldWeb(text)
    }

    override fun updateTextWeb(text: String?) {
        if(text!= null){
            model.setTextWebModel(text)
        }
    }

    override fun updateTextNative(text: String?) {
        if(text!= null){
            model.setTextNativeModel(text)
        }
    }

    fun getModel() = model.getTextModel()
}