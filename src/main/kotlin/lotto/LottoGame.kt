package lotto

import lotto.LottoController
import lotto.ScreenView
class LottoGame {
    private val view  = ScreenView()
    private val controller = LottoController(view = view)
    fun run() {
    }
}