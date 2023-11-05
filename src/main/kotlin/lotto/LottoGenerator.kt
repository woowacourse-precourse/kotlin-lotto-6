package lotto

import util.Validator

class LottoGenerator(var money: Int = 0) {

    val lottos: MutableList<Lotto> = mutableListOf()

    init {
      Validator.checkIsDivisibleByThousand(money)
    }

    fun create() {
        for (i in 1..moneyToCountByThousand()) lottos.add(Lotto())
    }

    private fun moneyToCountByThousand() = money / 1000
}