package lotto

import ui.UserOutput
import ui.InputValidator

class LottoGenerator(var money: Int) {

    val lottos: MutableList<Lotto> = mutableListOf()

    init {
        InputValidator
            .checkPurchaseRange(money)
            .checkIsDivisibleByThousand(money)
    }

    fun create() {
        for (i in 1..moneyToCountByThousand()) lottos.add(Lotto())
    }

    fun printAll() {
        println()
        UserOutput.printPurchaseResult(lottos.size)
        for (lotto in lottos) println(lotto.toAscendingList())
        println()
    }

    private fun moneyToCountByThousand() = money / 1000
}