package lotto.domain

class Money(private val money: String) {
    init {
        require(isNum()) { println(IS_NOT_NUM) }
        require(isMultiplesOfThousand()) { println(IS_NOT_MULTIPLES_OF_THOUSAND) }
    }

    private fun isNum(): Boolean = money.all { number -> number.isDigit() }

    private fun isMultiplesOfThousand(): Boolean = money.toInt() % 1000 == 0

    companion object {
        private const val IS_NOT_NUM = "[ERROR] 금액은 숫자여야 합니다."
        private const val IS_NOT_MULTIPLES_OF_THOUSAND = "[ERROR] 구입 금액은 1000원으로 나누어 떨어져야 합니다."
    }
}
