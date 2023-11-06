package lotto

import lotto.LottoController
import lotto.ScreenView
class LottoGame {
    private val view  = ScreenView()
    private val controller = LottoController(view = view)
    fun run() {
        val lottoQuantity = view.inputMoney()
        controller.buyLottos(lottoQuantity).print()

        view.inputLotto()
        view.inputBonusNum()
    }
}