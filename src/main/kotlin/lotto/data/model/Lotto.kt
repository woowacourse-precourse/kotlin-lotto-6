package lotto.data.model

import lotto.domain.util.const.ErrorMessage.error_duplicated_lotto_numbers
import lotto.domain.util.const.lottoWinningNumberQuantity

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if (numbers.toSet().size != lottoWinningNumberQuantity) throw IllegalArgumentException(
            error_duplicated_lotto_numbers
        )
    }

    fun getNumbers(): List<Int> = numbers
    fun printWinningNumbers() {
        println("[${numbers.joinToString()}]")
    }

    fun checkWinning(userInputNumbers: Lotto, userInputBonusNumber: Int): Winning? {
        val intersectCnt = userInputNumbers.numbers.intersect(numbers).size
        val isBonusNumberMatched = numbers.contains(userInputBonusNumber)
        return when (intersectCnt) {
            3 -> Winning.MatchingThreeCount
            4 -> Winning.MatchingFourCount
            5 -> {
                if (isBonusNumberMatched) Winning.MatchingFiveCountWithBonus
                Winning.MatchingFiveCount
            }

            6 -> Winning.MatchingSixCount
            else -> null
        }
    }
}

