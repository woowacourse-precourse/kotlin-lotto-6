package lotto.exception.model

import lotto.LOTTO_NUMBER_COUNT

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
    }

    // TODO: 추가 기능 구현
}
