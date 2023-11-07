package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.LOTTO_COUNT
import lotto.exception.IllegalStateException

class LottoManager {

    fun getMoneyToCount(money: Int): Int {
        while (money < LOTTO_PRICE) {
            println(IllegalStateException.stateNotInitialized)
        }

        return money / LOTTO_PRICE
    }

    fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT).sorted())
    }

    fun classifyLotto(lottoList: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): Map<LottoRank, Int> {
        val lottoMap = LottoRank.entries.associateWith { 0 }.toMutableMap()

        lottoList.forEach { lotto ->
            val lottoRank = compareLotto(lotto, winningLotto, bonusNumber)
            lottoMap[lottoRank] = lottoMap[lottoRank]!! + 1
        }
        lottoMap.remove(LottoRank.NOT_IN_RANK)

        return lottoMap
    }

    private fun compareLotto(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int): LottoRank {
        return when (winningLotto.getLottoNumbers().intersect(lotto.getLottoNumbers().toSet()).size) {
            6 -> LottoRank.FIRST_RANK
            7 -> if (lotto.getLottoNumbers().contains(bonusNumber)) LottoRank.SECOND_RANK else LottoRank.THIRD_RANK
            8 -> LottoRank.FOURTH_RANK
            9 -> LottoRank.FIFTH_RANK
            else -> LottoRank.NOT_IN_RANK
        }
    }
}