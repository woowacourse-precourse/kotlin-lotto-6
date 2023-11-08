package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.LottoConstants.LOTTO_COUNT
import lotto.constants.LottoConstants.LOTTO_PRICE
import lotto.constants.LottoConstants.MAX_LOTTO_NUMBER
import lotto.constants.LottoConstants.MIN_LOTTO_NUMBER
import lotto.exception.IllegalStateException

class LottoManager {

    fun getMoneyToCount(money: Int): Int {
        if (money == -1) throw IllegalStateException.stateNotInitialized

        return money / LOTTO_PRICE
    }

    fun generateLotto(): Lotto {
        return Lotto(Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_COUNT).sorted())
    }

    fun classifyLotto(lottoList: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): Map<LottoRank, Int> {
        val lottoMap = LottoRank.entries.associateWith { 0 }.toMutableMap()

        if (bonusNumber == -1 || lottoList.isEmpty()) throw IllegalStateException.stateNotInitialized

        lottoList.forEach { lotto ->
            val lottoRank = checkLotto(lotto, winningLotto, bonusNumber)
            lottoMap[lottoRank] = lottoMap[lottoRank]!! + 1
        }
        lottoMap.remove(LottoRank.NOT_IN_RANK)

        return lottoMap
    }

    fun checkLotto(lotto: Lotto, winningLotto: Lotto, bonusNumber: Int): LottoRank {

        if (bonusNumber == -1) throw IllegalStateException.stateNotInitialized

        return when (winningLotto.getLottoNumbers().intersect(lotto.getLottoNumbers().toSet()).size) {
            6 -> LottoRank.FIRST_RANK
            5 -> if (lotto.getLottoNumbers().contains(bonusNumber)) LottoRank.SECOND_RANK else LottoRank.THIRD_RANK
            4 -> LottoRank.FOURTH_RANK
            3 -> LottoRank.FIFTH_RANK
            else -> LottoRank.NOT_IN_RANK
        }
    }

    fun sumLotto(lottoMap: Map<LottoRank, Int>): Long {
        var reward = 0L
        lottoMap.forEach { (lottoRank, value) ->
            reward += lottoRank.reward * value
        }
        return reward
    }

    fun calculateProfitRate(count: Int, reward: Long): Double {
        val profitRate = (reward.toDouble() / (count * LOTTO_PRICE).toDouble()) * 100.0
        return String.format("%.1f", profitRate).toDouble()
    }
}