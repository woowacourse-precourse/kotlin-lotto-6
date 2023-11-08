package model

import util.InputValidation
import util.LottoValidation
import util.PrizeMessageRank

class WinningNumbersManager(numbers: List<String>) {

    private var winningNumbers: List<Int>
    private var bonusNumber = 0

    init {
        numbers.forEach {
            InputValidation.NUMBER_EMPTY.isValid(it)
            InputValidation.ONLY_NUMBER.isValid(it)
            InputValidation.NUMBER_RANGE.isValid(it)
            InputValidation.NUMBER_FORMAT.isValid(it)
        }
        winningNumbers = numbers.map { it.toInt() }
        LottoValidation.REQUIRED_LOTTO_NUMBER_COUNT.isValid(winningNumbers)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(winningNumbers)
        LottoValidation.LOTTO_NUMBER_RANGE.isValid(winningNumbers)
    }

    fun isBonusNumberValid(number: String) {
        InputValidation.NUMBER_EMPTY.isValid(number)
        InputValidation.ONLY_NUMBER.isValid(number)
        InputValidation.NUMBER_RANGE.isValid(number)
        InputValidation.NUMBER_FORMAT.isValid(number)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(winningNumbers.plus(number.toInt()))
        bonusNumber = number.toInt()
    }

    fun getRank(numbers: List<Int>): Int {
        when (winningNumbers.count { numbers.contains(it) }) {
            PrizeMessageRank.FIFTH.matchingCount -> return PrizeMessageRank.FIFTH.rank
            PrizeMessageRank.FOURTH.matchingCount -> return PrizeMessageRank.FOURTH.rank
            PrizeMessageRank.THIRD.matchingCount -> {
                if (numbers.contains(bonusNumber)) return PrizeMessageRank.SECOND.rank
                return PrizeMessageRank.THIRD.rank
            }

            PrizeMessageRank.FIRST.matchingCount -> return PrizeMessageRank.FIRST.rank
        }
        return 0
    }
}
