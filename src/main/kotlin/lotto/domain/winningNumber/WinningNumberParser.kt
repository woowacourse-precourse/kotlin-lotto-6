package lotto.domain.winningNumber

import lotto.constants.ErrorConstants
import lotto.domain.lotto.parser.LottoNumberParser

class WinningNumberParser {

    companion object {
        fun parseWinningNumbers(input: String): List<Int> {
            val numbers = input.split(",").map { it.trim() }
            val parsedNumbers = numbers.map { LottoNumberParser(it).number }

            if (parsedNumbers.distinct().size != parsedNumbers.size) {
                throw IllegalArgumentException(ErrorConstants.DISTINCT_ERROR_MESSAGE)
            } else if (parsedNumbers.size != 6) {
                throw IllegalArgumentException(ErrorConstants.COUNT_LOTTO_ERROR_MESSAGE)
            }

            return parsedNumbers
        }
    }
}
