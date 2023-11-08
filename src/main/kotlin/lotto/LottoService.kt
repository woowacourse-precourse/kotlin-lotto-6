package lotto

import camp.nextstep.edu.missionutils.Randoms
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
}
