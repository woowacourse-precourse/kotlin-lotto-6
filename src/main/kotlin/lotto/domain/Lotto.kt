package lotto.domain

import lotto.domain.BonusFlag.HIT_BONUS
import lotto.domain.BonusFlag.MISS_BONUS
import lotto.domain.LottoRank.FIFTH
import lotto.domain.LottoRank.FIRST
import lotto.domain.LottoRank.FOURTH
import lotto.domain.LottoRank.INIT
import lotto.domain.LottoRank.NOTHING
import lotto.domain.LottoRank.SECOND
import lotto.domain.LottoRank.THIRD
import lotto.domain.validator.LottoValidator.validateLottoNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoNumbers(numbers)
    }

    var lottoRank: LottoRank = INIT
        private set

    fun calculateWinningRank(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        val score: Pair<BonusFlag, Int> = calculateMatchingNumbers(winningNumbers, bonusNumber)
        val bonusFlag = score.first
        val matchingCount = score.second

        lottoRank = when (matchingCount) {
            6 -> FIRST
            5 -> calculateSecondThirdRank(bonusFlag)
            4 -> FOURTH
            3 -> FIFTH
            else -> NOTHING
        }
    }

    private fun calculateMatchingNumbers(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Pair<BonusFlag, Int> {
        var bonusFlag = MISS_BONUS
        var matchingCount = 0
        numbers.forEach { number ->
            if (number in winningNumbers) {
                matchingCount += 1
            }
            if (number == bonusNumber) {
                bonusFlag = HIT_BONUS
            }
        }
        return bonusFlag to matchingCount
    }

    private fun calculateSecondThirdRank(bonusFlag: BonusFlag): LottoRank {
        return when (bonusFlag) {
            HIT_BONUS -> SECOND
            MISS_BONUS -> THIRD
        }
    }

    override fun toString(): String = numbers.sorted().toString()

    companion object {
        val LOTTO_NUMBER_COUNT = 6
        val LOTTO_MIN_VALUE = 1
        val LOTTO_MAX_VALUE = 45
    }
}
