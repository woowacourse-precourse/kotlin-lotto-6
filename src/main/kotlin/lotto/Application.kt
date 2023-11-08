package lotto

import lotto.controller.LottoController
import lotto.util.HandleException
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    runCatching {
        val lottoController = LottoController(InputView(), OutputView(), HandleException())
        lottoController.run()
    }.onFailure {
        HandleException().printError(it.message)
    }
}
