package lotto.model

import lotto.util.Validator.validateLottoDuplicate
import lotto.util.Validator.validateLottoRange
import lotto.util.Validator.validateSize

class Lotto(private val numbers: List<Int>) {
    init {
        validateSize(numbers)
        validateLottoDuplicate(numbers)
        validateLottoRange(numbers)
    }

    fun getWinningNumbers(): List<Int> {
        return numbers
    }
}
