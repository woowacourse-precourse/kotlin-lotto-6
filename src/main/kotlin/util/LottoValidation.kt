package util

enum class LottoValidation(val message: String, val isValid: (List<Int>) -> Unit) {
    REQUIRED_LOTTO_NUMBER_COUNT(
        "[ERROR] 6개의 번호가 정확히 입력되지 않았습니다.",
        fun(numbers: List<Int>) = require(numbers.size == 6) { REQUIRED_LOTTO_NUMBER_COUNT.message },
    ),
    UNIQUE_LOTTO_NUMBERS(
        "[ERROR] 중복된 번호가 존재합니다.",
        fun(numbers: List<Int>) = require(numbers.toSet().size == 6) { UNIQUE_LOTTO_NUMBERS.message },
    ),
    LOTTO_NUMBER_RANGE(
        "[ERROR] 1 ~ 45 범위에 포함되지 않는 숫자가 존재합니다.",
        fun(numbers: List<Int>) = require(numbers.all { it in 1..45 }) { LOTTO_NUMBER_RANGE.message },
    ),
}
