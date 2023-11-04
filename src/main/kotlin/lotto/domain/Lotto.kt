package lotto.domain

import lotto.constant.Constant
import net.bytebuddy.pool.TypePool.Resolution.Illegal
import lotto.constant.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkValidationLottoNumber()
    }

    private fun checkValidationLottoNumber() {
        checkDuplicateLottoNumber()
        checkRangeLottoNumber()
    }

    private fun checkDuplicateLottoNumber() {
        if(numbers.distinct().size != numbers.size)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DUPLICATE)
    }

    private fun checkRangeLottoNumber() {
        for(number in numbers) {
            if(number !in Constant.MIN_LOTTO_NUMBER..Constant.MAX_LOTTO_NUMBER)
                throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_RANGE)
        }
    }

    fun getNumberPerLotto(): List<Int> {
        return numbers
    }
    // TODO: 추가 기능 구현
}
