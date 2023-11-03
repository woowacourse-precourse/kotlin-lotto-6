package lotto.domain

import net.bytebuddy.pool.TypePool.Resolution.Illegal
import lotto.constant.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        checkValidationLottoNumber(numbers)
    }

    private fun checkValidationLottoNumber(lottoNumber: List<Int>) {
        if(lottoNumber.distinct().size != lottoNumber.size)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DUPLICATE)
    }

    fun getNumberPerLotto(): List<Int> {
        return numbers
    }
    // TODO: 추가 기능 구현
}
