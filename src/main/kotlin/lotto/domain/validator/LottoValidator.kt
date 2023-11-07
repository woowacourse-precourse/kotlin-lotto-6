package lotto.domain.validator

import lotto.domain.Lotto.Companion.LOTTO_NUMBER_COUNT
import lotto.domain.validator.InputValidator.validateIntListHasUniqueElements
import lotto.domain.validator.InputValidator.validateNumbersInRange

object LottoValidator {
    fun validateLottoNumbers(numbers: List<Int>) = numbers.let {
        validateLottoNumbersSize(it)
        validateNumbersInRange(it, message = "로또 번호로는 1이상 45이하의 숫자만 입력할 수 있습니다")
        validateIntListHasUniqueElements(it, message = "로또 번호로 중복된 숫자는 입력할 수 없습니다.")
    }

    fun validateLottoNumbersSize(numbers: List<Int>) {
        require(numbers.size == LOTTO_NUMBER_COUNT) {
            "[ERROR] 로또 번호는 6자리 수로 이루어져야 합니다."
        }
    }
}