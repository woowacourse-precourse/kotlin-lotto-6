package lotto.view

import lotto.Lotto

class OutputView {

    fun printBuyLottos(buyLottos: List<Lotto>) {
        buyLottos.forEach{ lotto ->
            println(lotto)
        }
    }

}