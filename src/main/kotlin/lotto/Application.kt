package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()
    try {
        lottoController.startGame()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        lottoController.startGame()
    }
}