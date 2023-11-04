package lotto

import controller.LottoManager
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val lottoMng = LottoManager(InputView, OutputView)
    lottoMng.run()
}
