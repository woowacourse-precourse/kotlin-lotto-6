package lotto

import lotto.controller.LottoGameController
import lotto.view.ConsoleView

fun main() {
    val view = ConsoleView()
    val controller = LottoGameController(view)
    controller.startGame()
}