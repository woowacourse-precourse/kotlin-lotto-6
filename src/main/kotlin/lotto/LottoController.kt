package lotto

class LottoController {
    private val inputView = InputView()

    fun run() {
        val priceAmount = inputPriceAmount()
        println()
        val lottoCount = inputView.calculateCount(priceAmount)
    }

    private fun inputPriceAmount(): Int {
        while (true) {
            try {
                val priceAmountInput = inputView.validatePriceAmount()
                val intPriceAmount = inputView.validatePriceInt(priceAmountInput)
                val priceAmount = inputView.validatePriceRange(intPriceAmount)
                return inputView.validatePriceUnit(priceAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}