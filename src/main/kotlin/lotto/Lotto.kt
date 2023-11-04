package lotto

import lotto.utils.Constants
import lotto.utils.Messages

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_SIZE) {"${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_SIZE_MESSAGE}"}
        require(numbers.toSet().size == numbers.size) {
            "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}"
        }
    }

    // TODO: 추가 기능 구현
}
