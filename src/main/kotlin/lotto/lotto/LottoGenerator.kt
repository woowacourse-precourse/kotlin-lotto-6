package lotto.lotto

import lotto.consts.GameConst
import lotto.consts.ErrorStringRes
import lotto.createlotto.CreateLottoInterface

class LottoGenerator(private val strategy: CreateLottoInterface) {
    fun createLottos(budget: Int): List<Lotto> {
        require(budget % GameConst.COST == 0) {
            ErrorStringRes.BUDGET_REMAIN_ERR
        }
        val lottos = mutableListOf<Lotto>()
        for (i in 1..budget / GameConst.COST) {
            lottos.add(strategy.getLotto())
        }
        return lottos
    }
}