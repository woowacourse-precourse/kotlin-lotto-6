package lotto.utils

object Extensions {
    fun Int.withCommas(): String {
        return "%,d".format(this)
    }
}