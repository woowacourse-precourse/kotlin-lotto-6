package lotto.model

import lotto.util.Constant
import lotto.util.Constant.LOTTO_MAX_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_MIN_RANDOM_NUMBER
import lotto.util.Constant.LOTTO_NUMBER_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE
import lotto.util.Constant.LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) {LOTTO_NUMBER_NUMBER_LENGTH_ERROR_MESSAGE}
        require(numbers.max() <= LOTTO_MAX_RANDOM_NUMBER && numbers.min() >= LOTTO_MIN_RANDOM_NUMBER) { LOTTO_NUMBER_ERROR_MESSAGE}
        require(numbers.toSet().size==6) { LOTTO_NUMBER_OVERLAP_ERROR_MESSAGE}
    }

    // TODO: 추가 기능 구현
    fun getLottoNumbers() = numbers
}
