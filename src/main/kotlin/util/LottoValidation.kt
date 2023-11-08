package util

enum class LottoValidation(val message: String, val isValid: (List<Int>) -> Unit) {
    REQUIRED_LOTTO_NUMBER_COUNT(
        "[ERROR] 당첨번호는 ${LottoConfiguration.NUMBER_COUNT.value}개의 숫자로만 지정할 수 있습니다.",
        fun(numbers: List<Int>) =
            require(numbers.size == LottoConfiguration.NUMBER_COUNT.value) { REQUIRED_LOTTO_NUMBER_COUNT.message },
    ),
    UNIQUE_LOTTO_NUMBERS(
        "[ERROR] 중복된 번호가 존재합니다.",
        fun(numbers: List<Int>) = require(numbers.toSet().size == numbers.size) { UNIQUE_LOTTO_NUMBERS.message },
    ),
    LOTTO_NUMBER_RANGE(
        "[ERROR] 로또 번호는 ${LottoConfiguration.MIN_NUMBER.value}부터 ${LottoConfiguration.MAX_NUMBER.value}사이의 숫자여야 합니다.",
        fun(numbers: List<Int>) =
            require(numbers.all { it in LottoConfiguration.MIN_NUMBER.value..LottoConfiguration.MAX_NUMBER.value }) { LOTTO_NUMBER_RANGE.message },
    ),
}
