package lotto

import lotto.Controller.LottoGameController
import lotto.View.InputView
import lotto.View.OutputView
import lotto.domain.LottoGameService

fun main() {
    LottoGameController(
        inputView = InputView(),
        outputView = OutputView(),
        lottoGame = LottoGameService(),
    ).start()
}
