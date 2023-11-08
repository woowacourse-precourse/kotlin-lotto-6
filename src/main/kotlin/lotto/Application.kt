package lotto

import lotto.controller.LottoController

fun main() {
//    val lr = LottoRepository()
//    print(lr.generateLottoTickets(10))
    val lottoController = LottoController()
    lottoController.startGame()

}
