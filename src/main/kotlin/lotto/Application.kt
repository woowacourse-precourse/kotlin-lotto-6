package lotto

import lotto.controller.LottoController

fun main() {
    val lottoController = LottoController()
    try {
        lottoController.start()
    }catch (e:IllegalArgumentException){
        println(e.message)
    }

}
