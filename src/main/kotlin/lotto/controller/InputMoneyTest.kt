package lotto.controller

class InputMoneyTest(private val number: Int) {

    init {
        require(number % 1000 == 0)
    }

    fun getInputNumber(): Int {
        return number
    }
}