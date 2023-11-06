package util

enum class LottoValidation(val message: String, val validation: (List<Int>) -> Unit) {
    REQUIRED_LOTTO_NUMBER_COUNT(
        "[ERROR] 로또 번호는 6개여야 합니다.",
        fun(numbers: List<Int>) = require(numbers.size == 6) { REQUIRED_LOTTO_NUMBER_COUNT.message },
    ),
    UNIQUE_LOTTO_NUMBERS(
        "[ERROR] 로또 번호는 중복되어선 안됩니다.",
        fun(numbers: List<Int>) = require(numbers.toSet().size == 6) { UNIQUE_LOTTO_NUMBERS.message },
    ),
    LOTTO_NUMBER_RANGE(
        "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.",
        fun(numbers: List<Int>) = require(numbers.all { it in 1..45 }) { LOTTO_NUMBER_RANGE.message },
    )
}
