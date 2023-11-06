package lotto.model

import lotto.util.Validation.validateDuplicateNumbers


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] 로또는 6개의 숫자들입니다."}
        require(!validateDuplicateNumbers(numbers)) { "[ERROR] 로또는 중복되지 않는 숫자들입니다."}
    }

    fun issueNumbers() = numbers

}
