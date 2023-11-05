package lotto.domain

import lotto.utils.Constant.MAX_LOTTO_NUMBER
import lotto.utils.Constant.MIN_LOTTO_NUMBER

private const val WRONG_NUMBER_RANGE_EXCEPTION_MESSAGE = "[ERROR]로또 번호는 1부터 45 사이의 숫자여야 합니다! "

class LottoNumber(val number: Int) {

    init {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { WRONG_NUMBER_RANGE_EXCEPTION_MESSAGE }
    }

    override fun equals(other: Any?): Boolean {
        if (other is LottoNumber) return other.number == this.number
        return false
    }

    override fun hashCode() = number

    override fun toString() = number.toString()

}