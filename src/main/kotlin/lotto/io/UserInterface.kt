package lotto.io

import java.lang.IllegalArgumentException

class UserInterface(
    private val output: Output = Output(),
    private val input: Input = Input()
) {
    fun askPurchaseAmount():Int {
        while(true) {
            val purchaseAmount:Int
            try{
                output.printAmountMsg()
                purchaseAmount = input.enterPurchaseAmount()

                return purchaseAmount
            } catch (e:IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun askWinningNumbers(): List<Int> {
        while(true) {
            val winningNumbers: List<Int>
            try {
                output.printWinningNumbersMsg()
                winningNumbers = input.enterWinningNumbers()

                return winningNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }


}