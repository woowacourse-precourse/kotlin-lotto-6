package lotto.domain

import lotto.utils.Constant.INVALID_SIZE_EXCEPTION_MESSAGE
import lotto.utils.Constant.LOTTO_NUMBER_SIZE

class WinningLotto(private val numbers: List<LottoNumber>) {

    init {
        require(numbers.size == LOTTO_NUMBER_SIZE) { INVALID_SIZE_EXCEPTION_MESSAGE }
    }
}


