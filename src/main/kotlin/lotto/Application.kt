package lotto

import lotto.controller.Controller
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    Controller(InputView(), OutputView()).startGame()
}
