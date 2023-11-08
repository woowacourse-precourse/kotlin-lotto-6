package lotto.domain.lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.constants.ErrorConstants.COUNT_LOTTO_ERROR_MESSAGE
import lotto.constants.ErrorConstants.DISTINCT_ERROR_MESSAGE
import lotto.constants.GameConstants.LOTTO_COUNT
import lotto.constants.GameConstants.MAX_NUMBER
import lotto.constants.GameConstants.MIN_NUMBER
import lotto.domain.lotto.wrapper.LottoNumber

class Lotto(private val numbers: List<LottoNumber> = generateRandomNumbers()) {
    init {
        require(numbers.size == LOTTO_COUNT) { COUNT_LOTTO_ERROR_MESSAGE }
        require(numbers.distinctBy { it.number }.size == LOTTO_COUNT) { DISTINCT_ERROR_MESSAGE }
    }

    companion object {
        private fun generateRandomNumbers(): List<LottoNumber> {
            val randomNumbers = mutableSetOf<LottoNumber>()
            while (randomNumbers.size < LOTTO_COUNT) {
                val randomNumber = Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER)
                randomNumbers.add(LottoNumber(randomNumber))
            }
            return randomNumbers.toList().sortedBy { it.number }
        }
    }

    fun getNumbers(): List<LottoNumber> {
        return numbers
    }

    override fun toString(): String {
        return numbers.joinToString(separator = ", ", prefix = "[", postfix = "]") { it.number.toString() }
    }
}
