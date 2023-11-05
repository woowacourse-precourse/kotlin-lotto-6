package lotto

class Calculator() {

    fun calculateLottoAvailableForPurchase(cost: String): Int {
        val number = cost.toIntOrNull() ?: throw IllegalArgumentException()
        require(number > 0)
        return (number / 1000)
    }

}