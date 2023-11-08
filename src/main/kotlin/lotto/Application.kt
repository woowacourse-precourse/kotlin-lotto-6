package lotto

import lotto.controller.LottoGame
import lotto.domain.LottoMachine
import lotto.domain.Player
import lotto.view.OutputView

fun main() {
    val output = OutputView()
    val player = Player()
    val lottoMachine = LottoMachine()
    val lottoGame = LottoGame(output, player, lottoMachine)
    lottoGame.start()
}







