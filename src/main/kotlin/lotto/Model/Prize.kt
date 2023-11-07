package lotto.Model

object Prize {
    fun getPrize(key: String): String {
        return when (key) {
            "3" -> "5,000"
            "4" -> "50,000"
            "5" -> "1,500,000"
            "5.1" -> "30,000,000"
            "6" -> "2,000,000,000"
            else -> "0"
        }
    }
}
