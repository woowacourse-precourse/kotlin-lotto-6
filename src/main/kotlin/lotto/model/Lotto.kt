package lotto.model

import lotto.domain.RandomGenerator
import lotto.errorMessageFormat
import lotto.view.InputView.ERROR_PRIZE_SIZE_MESSAGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == MAX_LOTTO_SIZE) {
            errorMessageFormat(ERROR_PRIZE_SIZE_MESSAGE)
        }
    }

    fun getLottoNumbers(): List<LottoNumber> {
        return numbers.map { LottoNumber(it) }
    }

    fun getWinningCount(winningLotto: Lotto): Int {
        var prizeCount = 0
        numbers.forEach {
            prizeCount += confirmPrizeNumbers(it, winningLotto)
        }
        return prizeCount
    }

    fun confirmBonusNumber(winningCount: Int, bonusNumber: Int): Boolean {
        return winningCount == LottoPrize.SECOND.prizeCount && numbers.contains(bonusNumber)
    }

    private fun confirmPrizeNumbers(currentNum: Int, winningLotto: Lotto): Int {
        if (winningLotto.numbers.contains(currentNum)) {
            return 1
        }
        return 0
    }


    companion object {
        private const val MIN_LOTTO_RANGE = 1

        const val MAX_LOTTO_SIZE = 6
        const val MAX_LOTTO_RANGE = 45
        fun makeLotto(randomLottoGenerator: RandomGenerator): Lotto {
            return Lotto(randomLottoGenerator.pickNumberInRange(MIN_LOTTO_RANGE, MAX_LOTTO_RANGE, MAX_LOTTO_SIZE))
        }
    }
}
