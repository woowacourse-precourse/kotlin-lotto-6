package lotto.domain.winning.parser

import lotto.constants.ErrorConstants
import lotto.constants.GameConstants.COMMA
import lotto.constants.GameConstants.LOTTO_COUNT
import lotto.domain.lotto.parser.LottoNumberParser

class WinningNumberParser {

    companion object {
        fun parseWinningNumbers(input: String): List<Int> {
            val numbers = input.split(COMMA).map { it.trim() }
            val parsedNumbers = numbers.map { LottoNumberParser(it).number }

            if (parsedNumbers.distinct().size != parsedNumbers.size) {
                throw IllegalArgumentException(ErrorConstants.DISTINCT_ERROR_MESSAGE)
            } else if (parsedNumbers.size != LOTTO_COUNT) {
                throw IllegalArgumentException(ErrorConstants.COUNT_LOTTO_ERROR_MESSAGE)
            }

            return parsedNumbers
        }
    }
}
