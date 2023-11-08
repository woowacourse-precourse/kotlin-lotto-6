package lotto

import lotto.Constants.Companion.ERROR_INVALID_PURCHASE_AMOUNT_MESSAGE
import lotto.Constants.Companion.ERROR_OUT_OF_RANGE_NUMBER_MESSAGE
import lotto.Constants.Companion.ERROR_OVERLAP_NUMBER_MESSAGE
import lotto.Constants.Companion.MAX_LOTTO_NUMBER
import lotto.Constants.Companion.MIN_LOTTO_NUMBER
class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        // 숫자가 6개가 아니면
        { ERROR_INVALID_PURCHASE_AMOUNT_MESSAGE }
        require(numbers.distinct().size == 6)
        //당첨 번호 중복되면
        { ERROR_OVERLAP_NUMBER_MESSAGE }
        require(numbers.all { it in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER })
        //숫자 범위 아니면
        { ERROR_OUT_OF_RANGE_NUMBER_MESSAGE }
    }
    val getNumber: List<Int>
        get() = numbers

    }




