package lotto

import lotto.controller.GameController
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val controller = GameController(InputView(), OutputView())
    controller.start()
}
