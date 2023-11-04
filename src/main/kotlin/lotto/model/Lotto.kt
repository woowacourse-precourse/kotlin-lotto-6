package lotto.model

import lotto.util.Validator.validateLottoLength
import lotto.util.Validator.validateLottoRange
import lotto.util.Validator.validateLottoUnique

class Lotto(private val numbers: List<Int>) {
    init {
        validateLottoLength(numbers)
        validateLottoUnique(numbers)
        validateLottoRange(numbers)
    }

    fun isValidBonusNumber(bonus: Int) {
        require(!numbers.contains(bonus)) { "보너스 번호가 당첨번호와 중복됩니다." }
    }
}