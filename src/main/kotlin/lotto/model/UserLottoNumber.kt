package lotto.model

import java.lang.NumberFormatException

class UserLottoNumber {
    fun convert(numbers: String): List<Int> {
        val lottoNumber = numbers.split(',')
        val integers = mutableListOf<Int>()
        for (number in lottoNumber) {
            validate(number)
            integers.add(number.toInt())
        }
        return integers
    }

    private fun validate(number: String) {
        try {
            number.toInt()
        } catch (e: NumberFormatException) {
            error(Constants.ERROR_LOTTO_FORMAT)
        }
    }
}