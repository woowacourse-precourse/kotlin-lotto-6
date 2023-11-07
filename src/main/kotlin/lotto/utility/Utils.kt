package lotto.utility

class Utils {
    companion object {
        fun roundToOneDeimalPlace(num: Double): Double {
            val roundedNumber = (num * 10.0).toInt() / 10.0

            return roundedNumber
        }
    }
}