package lotto.model

class Count {
    fun calculate(number: Int): Int {
        return number / NumberConstants.TEN_THOUSAND.value
    }
}