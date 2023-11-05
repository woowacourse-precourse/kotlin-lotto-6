package lotto

import util.Validator

class LottoGenerator(var money: Int = 0) {

    init {
      Validator.checkIsDivisibleByThousand(money)
    }

    fun create(): MutableList<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()
        for (i in 1..moneyToCountByThousand()) lottos.add(Lotto())

        return lottos
    }

    private fun moneyToCountByThousand() = money / 1000
}