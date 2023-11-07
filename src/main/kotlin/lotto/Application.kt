package lotto

import lotto.controller.LottoController

fun main() {
    try {
        val lottoController = LottoController()
        lottoController.start()
    } catch (e: IllegalArgumentException) {
        println(e.message)
        main()
    }
}

