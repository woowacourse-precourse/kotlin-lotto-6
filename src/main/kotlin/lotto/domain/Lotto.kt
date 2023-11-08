package lotto.domain

import lotto.domain.validator.LottoValidator.validateLottoNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoNumbers(numbers)
    }

    var lottoRank: LottoRank = LottoRank.INIT
        private set

    fun getLottoNumbers(): List<Int> {
        return numbers.toList().sorted()
    }

    fun calculateWinningRank(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ) {
        val score: Pair<BonusFlag, Int> = calculateMatchingNumbers(winningNumbers, bonusNumber)
        val bonusFlag = score.first
        val matchingCount = score.second

        println("matchingCount "+matchingCount.toString())
        lottoRank = when (matchingCount) {
            6 -> LottoRank.FIRST
            5 -> calculateSecondThirdRank(bonusFlag)
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> LottoRank.NOTHING
        }
    }

    private fun calculateMatchingNumbers(
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Pair<BonusFlag, Int> {
        var bonusFlag = BonusFlag.MISS_BONUS
        var matchingCount = 0
        numbers.forEach { number ->
            if (number in winningNumbers) {
                matchingCount += 1
            }
            if (number == bonusNumber) {
                bonusFlag = BonusFlag.HIT_BONUS
            }
        }
        return bonusFlag to matchingCount
    }

    private fun calculateSecondThirdRank(bonusFlag: BonusFlag): LottoRank {
        return when (bonusFlag) {
            BonusFlag.HIT_BONUS -> LottoRank.SECOND
            BonusFlag.MISS_BONUS -> LottoRank.THIRD
        }
    }

    companion object {
        val LOTTO_NUMBER_COUNT = 6
        val LOTTO_MIN_VALUE = 1
        val LOTTO_MAX_VALUE = 45
    }
}
