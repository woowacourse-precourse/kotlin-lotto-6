package lotto

import lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()

    try {
        lottoController.playGame()
    } catch (e: Exception) {
        println(e.message)
    }

}
