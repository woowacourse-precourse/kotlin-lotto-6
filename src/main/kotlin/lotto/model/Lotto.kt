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

    // TODO: 추가 기능 구현
}