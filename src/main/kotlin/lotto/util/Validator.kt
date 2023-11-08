package lotto.util

import lotto.util.Constants.MAXIMUM_LOTTO_NUMBER
import lotto.util.Constants.MINIMUM_LOTTO_NUMBER

object Validator {

    fun validateIsUnique(numbers: List<Int>) {
        require(numbers.size == numbers.toSet().size) { DUPLICATED_NUMBERS }
    }

    fun validateRange(number: Int) {
        require(number in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { INVALID_RANGE }
    }

    private const val DUPLICATED_NUMBERS = "당첨 번호끼리 중복되지 않도록 입력해 주세요"
    private const val INVALID_RANGE = "1부터 45까지의 숫자를 입력해 주세요"
}