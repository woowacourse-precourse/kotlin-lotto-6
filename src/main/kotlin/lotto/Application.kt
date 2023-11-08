package lotto

import lotto.controller.LottoController
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val outputView = OutputView()
    val inputView = InputView()
    val controller = LottoController(outputView, inputView)
    controller.start()
}