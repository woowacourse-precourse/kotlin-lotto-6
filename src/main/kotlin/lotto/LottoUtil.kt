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

    fun List<String>.isAllNumbers(): Boolean {
        return all { isStringNumber(it) }
    }

    fun List<String>.toIntList(): List<Int> {
        return map { it.toInt() }
    }

    fun List<Int>.isAllInLottoRange(): Boolean {
        return all { it.isInLottoRange() }
    }

    fun Int.isInLottoRange(): Boolean {
        return this in 1..45
    }

    val <T> List<T>.uniqueSize: Int
        get() = this.toSet().size

    val Int.commaString: String
        get() = "%,d".format(this)

}