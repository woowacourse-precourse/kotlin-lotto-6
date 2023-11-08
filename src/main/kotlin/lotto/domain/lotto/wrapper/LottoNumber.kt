package lotto.domain.lotto.wrapper

import lotto.constants.ErrorConstants.RANGE_ERROR_MESSAGE
import lotto.constants.GameConstants.MAX_NUMBER
import lotto.constants.GameConstants.MIN_NUMBER

data class LottoNumber(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) {
            RANGE_ERROR_MESSAGE
        }
    }
}
