package lotto

import lotto.controller.GameController
import lotto.util.Task

fun main() {
    val lottocontroller = GameController()
    val task = Task()

    lottocontroller.play(task)
}
