package lotto.model

import lotto.MAX_LOTTO_RANGE
import lotto.MAX_LOTTO_SIZE
import lotto.MIN_LOTTO_RANGE
import lotto.domain.RandomGenerator
import lotto.errorMessageFormat
import lotto.view.InputView.ERROR_PRIZE_SIZE_MESSAGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == MAX_LOTTO_SIZE) {
            errorMessageFormat(ERROR_PRIZE_SIZE_MESSAGE)
        }
    }

    fun getLottoState(): List<LottoState> {
        return numbers.map { LottoState(it) }
    }

    fun getWinningCount(winningLotto: Lotto): Int {
        var prizeCount = 0
        numbers.forEach {
            prizeCount += confirmPrizeNumbers(it, winningLotto)
        }
        return prizeCount
    }

    fun confirmBonusNumber(winningCount: Int, bonusNumber: Int): Boolean {
        if (winningCount == LottoPrize.SECOND.prizeCount) {
            return numbers.contains(bonusNumber)
        }
        return false
    }

    private fun confirmPrizeNumbers(currentNum: Int, winningLotto: Lotto): Int {
        if (winningLotto.numbers.contains(currentNum)) {
            return 1
        }
        return 0
    }


    companion object {
        fun makeLotto(randomLottoGenerator: RandomGenerator): Lotto {
            return Lotto(randomLottoGenerator.pickNumberInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, MAX_LOTTO_SIZE))
        }
    }
}
