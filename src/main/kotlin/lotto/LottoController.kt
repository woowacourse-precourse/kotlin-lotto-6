package lotto

class LottoController {
    private val inputView = InputView()

    fun run() {
        val priceAmount = inputPriceAmount()
        val lottoCount = priceAmount / 1000
        println(lottoCount)
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