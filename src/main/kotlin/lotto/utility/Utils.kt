package lotto.utility

import lotto.SCALE_UP
import lotto.SEPARATOR
import lotto.exception.UnvalidLottoNumberException

class Utils {
    companion object {
        fun roundToOneDeimalPlace(num: Double): Double {
            return (num * SCALE_UP + 0.5).toInt() / SCALE_UP
        }
        fun parseWithComma(input: String): List<Int> {
            val numberList = mutableListOf<Int>()
            val numbers = input.split(SEPARATOR)

            for (number in numbers) {
                try {
                    val intValue = number.trim().toInt()
                    numberList.add(intValue)
                } catch (error: UnvalidLottoNumberException) {
                    println("${error.message}")
                }
            }
            return numberList
        }

        fun containsNonDigits(input: String): Boolean {
            val regex = Regex("[^0-9]")
            return regex.containsMatchIn(input)
        }
    }
}