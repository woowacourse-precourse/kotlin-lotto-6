package lotto

object LottoUtil {

    fun printErrorMessage(message: String) {
        println(message)
        println()
    }

    fun isStringNumber(str: String): Boolean {
        return try {
            str.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isMultipleOf1000(value: Int): Boolean {
        return value % 1000 == 0
    }

}