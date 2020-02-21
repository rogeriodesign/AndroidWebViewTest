package br.com.capgemini.webviewetesteunitario

class Repository(private val presenter: MainContract.PresenterImpl): MainContract.ModelImpl {
    private var textModel = TextModel("", "")

    override fun getTextModel() = textModel

    override fun setTextNativeModel(value: String) {
        textModel.textFieldNative = value
        presenter.responseUpdateTextNative(textModel.textFieldNative)
    }

    override fun setTextWebModel(value: String) {
        textModel.textFieldWeb = value
        presenter.responseUpdateTextWeb(textModel.textFieldWeb)
    }
}