package lotto.controller


import lotto.view.LottoSystemView
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.InputStream

class LottoSystemControllerTest {
    private lateinit var lottoSystemView: LottoSystemView
    private lateinit var lottoController: LottoSystemController

    @BeforeEach
    fun setUp(){
        lottoSystemView = LottoSystemView()
        lottoController = LottoSystemController(lottoSystemView)
    }

    @Test
    fun `run`(){
        val input = "13000\n31,21,3,19,45,7\n9\n"
        val inputStream: InputStream = ByteArrayInputStream(input.toByteArray())
        System.setIn(inputStream)
        lottoController.run()
        // 랜덤값인데 어떻게 결과를 예측할까?
    }
}
