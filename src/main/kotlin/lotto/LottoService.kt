package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.enumeration.Bonus
import lotto.enumeration.Buy
import lotto.enumeration.Winning

class LottoService {
    fun buyLotto(buyCount: Int): List<Lotto> {
        val buyLottos = mutableListOf<Lotto>()
        repeat(buyCount) {
            buyLottos.add(Lotto(lottoMaker()))
        }
        return buyLottos
    }


    private fun lottoMaker(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }

    fun checkInvalidBuyPrice(buyPrice: String) {
        when {
            buyPrice.toIntOrNull() == null -> throw IllegalArgumentException(Buy.ERROR_NOT_INTEGER.value)
            buyPrice.toInt() % 1000 != 0 -> throw IllegalArgumentException(Buy.ERROR_NOT_THOUSAND.value)
            buyPrice.toInt() == 0 -> throw IllegalArgumentException(Buy.ERROR_NOT_THOUSAND.value)
        }
    }

    fun checkInvalidWinningNumbers(winningNumbers: List<String>) {
        when {
            winningNumbers.map { it.toIntOrNull() }
                .contains(null) -> throw IllegalArgumentException(Winning.ERROR_NOT_INTEGER.value)

            winningNumbers.map { it.toInt() }
                .any { it !in 1..45 } -> throw IllegalArgumentException(Winning.ERROR_NOT_RANGE.value)

            winningNumbers.size != 6 -> throw IllegalArgumentException(Winning.ERROR_NOT_SIX.value)
            winningNumbers.map { it.toInt() }
                .distinct().size != 6 -> throw IllegalArgumentException(Winning.ERROR_NOT_UNIQUE.value)
        }
    }

    fun checkInvalidBonusNumber(bonusNumber: String, winningLotto: Lotto) {
        when {
            bonusNumber.toIntOrNull() == null -> throw IllegalArgumentException(Bonus.ERROR_NOT_INTEGER.value)
            bonusNumber.toInt() !in 1..45 -> throw IllegalArgumentException(Bonus.ERROR_NOT_RANGE.value)
            bonusNumber.toInt() in winningLotto.getNumbers() -> throw IllegalArgumentException(Bonus.ERROR_NOT_UNIQUE.value)
        }
    }

    fun LottoResult(lottos: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): List<Int> {
        val result = mutableListOf<Int>(0, 0, 0, 0, 0, 0)
        lottos.forEach {
            when (it.matchCount(winningLotto)) {
                3 -> result[0]++
                4 -> result[1]++
                5 -> {
                    if (it.matchBonusNumber(bonusNumber)) {
                        result[3]++
                    } else {
                        result[2]++
                    }
                }

                6 -> result[4]++
                else -> result[5]++
            }
        }
        return result
    }

    fun calculateEarnRate(result: List<Int>): Any {
        val total = result.sum()
        return (result[0] * 5000 + result[1] * 50000 + result[2] * 1500000 + result[3] * 30000000 + result[4] * 2000000000) / (total * 100)
    }
}
