package lotto.domain

import lotto.Lotto
import camp.nextstep.edu.missionutils.Randoms

class BuyLottos {
    fun buyLottos(buyAmount: Int) : List<Lotto> {
        println(BUY_LOTTO_NUMBER.format(buyAmount))
        val buyLottos = mutableListOf<Lotto>()

        for (lottoCount in LOTTO_COUNT_START..buyAmount) {
            buyLottos.add(Lotto(generateLottoNumbers()))
        }
        
        return buyLottos
    }

    fun generateLottoNumbers(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(RANDOM_START_RANGE_NUMBER, RANDOM_END_RANGE_NUMBER, LOTTO_NUMBER_COUNT)
    }

    companion object {
        const val BUY_LOTTO_NUMBER = "\n%d개를 구매했습니다."
        const val LOTTO_COUNT_START = 1
        const val RANDOM_START_RANGE_NUMBER = 1
        const val RANDOM_END_RANGE_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
    }
}