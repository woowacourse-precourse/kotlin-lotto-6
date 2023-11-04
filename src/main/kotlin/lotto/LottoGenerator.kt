package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoGenerator {

    internal fun create(money: Int = 1000): MutableList<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()
        for (i in 1..money/1000) lottos.add(Lotto())

        return lottos
    }

}