package lotto.domain

import lotto.utils.Constant.DUPLICATE_NUMBER_EXCEPTION_MESSAGE
import lotto.utils.Constant.INVALID_SIZE_EXCEPTION_MESSAGE
import lotto.utils.Constant.LOTTO_NUMBER_SIZE

class Lotto(private val numbers: List<LottoNumber>) : List<LottoNumber> by numbers {
    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_EXCEPTION_MESSAGE }
        require(numbers.size == numbers.toSet().size) { DUPLICATE_NUMBER_EXCEPTION_MESSAGE }
    }
}
