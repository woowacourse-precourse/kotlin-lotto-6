package lotto.domain

import lotto.domain.validator.LottoManagerValidator.validateBonusNumberInput
import lotto.domain.validator.LottoManagerValidator.validateNoDuplicateNumbers
import lotto.domain.validator.LottoManagerValidator.validateWinningNumbersInput

class LottoManager {
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber: Int? = null

    fun setWinningNumbers(input: String) {
        validateWinningNumbersInput(input)
        winningNumbers = input.split(",").map {
            it.trim().toInt()
        }
    }

    fun setBonusNumber(input: String) {
        validateBonusNumberInput(input)
        validateNoDuplicateNumbers(winningNumbers, input)
        bonusNumber = input.toInt()
    }

    fun calculateMatchingNumbers(lottoNumbers: List<Int>): Pair<BonusFlag, Int> {
        var bonusFlag = BonusFlag.MISS_BONUS
        var matchingCount = 0

        lottoNumbers.forEach { number ->
            if (number in winningNumbers) {
                matchingCount += 1
            }
            if (number == bonusNumber) {
                bonusFlag = BonusFlag.HIT_BONUS
                matchingCount += 1
            }
        }

        return bonusFlag to matchingCount
    }

    fun calculateWinningRank(score: Pair<BonusFlag, Int>): LottoRank {
        val bonusFlag = score.first
        val matchingCount = score.second

        return when (matchingCount) {
            6 -> LottoRank.FIRST
            5 -> calculateSecondThirdRank(bonusFlag)
            4 -> LottoRank.FOURTH
            3 -> LottoRank.FIFTH
            else -> LottoRank.NOTHING
        }
    }

    private fun calculateSecondThirdRank(bonusFlag: BonusFlag): LottoRank {
        return when (bonusFlag) {
            BonusFlag.HIT_BONUS -> LottoRank.SECOND
            BonusFlag.MISS_BONUS -> LottoRank.THIRD
        }
    }
}