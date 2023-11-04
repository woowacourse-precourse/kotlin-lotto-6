package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {

    internal fun create(money: Int = 1000): MutableList<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()
        val count = moneyToCount(money)
        for (i in 2..count) lottos.add(Lotto())

        return lottos
    }

    private fun moneyToCount(money: Int): Int {
        require(money % 1000 == 0)
        return money / 1000
    }

}