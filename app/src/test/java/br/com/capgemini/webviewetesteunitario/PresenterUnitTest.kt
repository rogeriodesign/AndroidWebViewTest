package br.com.capgemini.webviewetesteunitario

import org.junit.Test
import org.junit.Assert.*
import org.junit.Before

class PresenterUnitTest {
    class ViewTest: MainContract.ViewImpl{
        var textFieldNative = ""
        var textFieldWeb = ""

        override fun getFieldNativeText(): String {
            return "Texto de teste"
        }

        override fun fillFieldWeb(text: String) {
            textFieldWeb = text
        }

        override fun fillFieldNative(text: String) {
            textFieldNative = text
        }
    }

    private val VIEW = ViewTest()
    private val PRESENTER = Presenter()

    @Before
    fun setUp() {
        PRESENTER.setView(VIEW)
    }


    @Test
    fun deve_SalvarNoModeloTextoEditado_QuandoAtualizaTextoDoCampoNativo() {
        PRESENTER.updateTextNative("texto de teste 1")

        assertEquals("texto de teste 1", PRESENTER.getModel().textFieldNative)
    }

    @Test
    fun deve_EnviarParaVisualizacaoCampoWeb_QuandoAtualizaTextoDoCampoNativo() {
        PRESENTER.updateTextNative("texto de teste 1")

        assertEquals("texto de teste 1", VIEW.textFieldWeb)
    }

    @Test
    fun deve_SalvarNoModeloTextoEditado_QuandoAtualizaTextoDoCampoWeb() {
        PRESENTER.updateTextWeb("texto de teste 1")

        assertEquals("texto de teste 1", PRESENTER.getModel().textFieldWeb)
    }

    @Test
    fun deve_EnviarParaVisualizacaoCampoNative_QuandoAtualizaTextoDoCampoWeb() {
        PRESENTER.updateTextWeb("texto de teste 1")

        assertEquals("texto de teste 1", VIEW.textFieldNative)
    }

}
