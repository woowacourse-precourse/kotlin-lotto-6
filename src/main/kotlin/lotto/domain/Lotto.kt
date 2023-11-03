package lotto.domain

import lotto.utils.Constant.LOTTO_NUMBER_SIZE

private const val INVALID_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또의 숫자 갯수는 6개여야 합니다!"

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_EXCEPTION_MESSAGE }
    }
}
