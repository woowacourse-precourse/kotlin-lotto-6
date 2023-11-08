package lotto

class LottoController (private val
    inputview: InputView = InputView(),
                       private val outputview: OutputView = OutputView()) {
        init {
            val amount: Int = getAmount()
        }
        private fun getAmount(): Int {
            var amount: Int
            while(true) {
                try{
                    outputview.amountMessage()
                    amount = inputview.inputPayment()
                    return amount
                } catch (e: IllegalArgumentException) {
                    println(e)
                }
            }
        }
    }
}