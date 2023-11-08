package lotto

import lotto.controller.GameController
import lotto.util.Task
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val task = Task()

    val lottoController = GameController(inputView, outputView)
    lottoController.play(task)
}