package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoModel {

    companion object {
        const val LOTTO_PRICE = 1000
    }

    fun buyLotto(price: Int): List<Lotto> {
        val lottoCount = price / LOTTO_PRICE
        return List(lottoCount) { generateLottoNum() }
    }

    private fun generateLottoNum(): Lotto {
        val number = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        number.sort()
        return Lotto(number)
    }

    fun calculateResult(lottos: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()

        lottos.forEach { lotto ->
            val matchCount = lotto.matchCount(winningNumbers)
            val matchBonus = lotto.hasBonusNumber(bonusNumber)
            val rank = Rank.lottoResult(matchCount, matchBonus)

            result[rank] = result.getOrDefault(rank, 0) + 1
        }
        return result
    }

}