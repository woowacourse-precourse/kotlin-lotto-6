package lotto

import lotto.controller.LottoGame
import lotto.view.Input
import lotto.view.Output

fun main() {

    val lottoGame = LottoGame(Input(), Output())
    lottoGame.play()
}
