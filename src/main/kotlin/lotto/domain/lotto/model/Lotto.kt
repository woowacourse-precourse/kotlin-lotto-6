package lotto.domain.lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.ErrorConstants.COUNT_LOTTO_ERROR_MESSAGE
import lotto.constants.ErrorConstants.DISTINCT_ERROR_MESSAGE
import lotto.constants.GameConstants.MAX_NUMBER
import lotto.constants.GameConstants.MIN_NUMBER
import lotto.domain.lotto.wrapper.LottoNumber

class Lotto(private val numbers: List<LottoNumber> = generateRandomNumbers()) {
    init {
        require(numbers.size == 6) { COUNT_LOTTO_ERROR_MESSAGE }
        require(numbers.distinctBy { it.number }.size == 6) { DISTINCT_ERROR_MESSAGE }
    }

    companion object {
        private fun generateRandomNumbers(): List<LottoNumber> {
            val randomNumbers = mutableSetOf<LottoNumber>()
            while (randomNumbers.size < 6) {
                val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
                randomNumbers.add(LottoNumber(randomNumber))
            }
            return randomNumbers.toList().sortedBy { it.number }
        }
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") { it.number.toString() }
    }
}
