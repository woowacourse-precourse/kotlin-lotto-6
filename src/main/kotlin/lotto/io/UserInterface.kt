package lotto.io

import lotto.model.LottoRank
import java.lang.IllegalArgumentException

class UserInterface(
    private val output: Output = Output(),
    private val input: Input = Input()
) {
    fun askPurchaseAmount(): Int {
        while (true) {
            val purchaseAmount: Int
            try {
                output.printAmountMsg()
                purchaseAmount = input.enterPurchaseAmount()

                return purchaseAmount
            } catch (e: IllegalArgumentException) {
                println(e.message)

            }
        }
    }

    fun askWinningNumbers(): List<Int> {
        while (true) {
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

    fun askBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            val bonusNumber: Int
            try {
                output.printBonusNumberMsg()
                bonusNumber = input.enterBonusNumber(winningNumbers)

                return bonusNumber
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun printLotto(lottoTickets: List<Int>) {
        output.printLotto(lottoTickets)
    }

    fun printLottoCounts(counts: Int) {
        output.printQuantityMsg(counts)
    }

    fun showMyResult(lottoResult: Map<LottoRank, Int>, profitRate: String) {
        output.printResult(lottoResult, profitRate)
    }


}