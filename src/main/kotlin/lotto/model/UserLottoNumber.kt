package lotto.model

import java.lang.NumberFormatException

class UserLottoNumber {
    fun convert(numbers: String): List<Int> {
        val lottoNumber = numbers.split(',')
        val integer = mutableListOf<Int>()
        for (number in lottoNumber) {
            validate(number)
            integer.add(number.toInt())
        }
        return integer
    }

    fun validate(number: String) {
        try {
            number.toInt()
        } catch (e: NumberFormatException) {
            println(Constants.ERROR_LOTTO_FORMAT)
        }
    }
}