package lotto

import lotto.controller.LottoGameController
import lotto.domain.LottoGameImpl
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    LottoGameController(
        inputView = InputView(),
        outputView = OutputView(),
        lottoGame = LottoGameImpl(),
    ).run()
}
