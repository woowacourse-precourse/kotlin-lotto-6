package lotto.Controller

import lotto.Model.LottoTicket
import lotto.Model.Result
import lotto.View.*
import java.util.*

class GameController {
    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val lottoTickets = LottoTicket.generateLottoTickets(purchaseAmount)
        Output.printLotto(lottoTickets)
        val winningNumbers = readWinningNumbers()
        val bonusNumber = readBonusNumber()
        val result = Result.calculateResults(lottoTickets, winningNumbers, bonusNumber)
        val profitRate = Result.calculateProfitRate(result)
        Output.printResults(result, profitRate)
    }

    private fun readPurchaseAmount(): Int {
        while (true) {
            try {
                val purchaseAmountString = Input.readPurchaseAmount()
                val purchaseAmount = purchaseAmountString.toInt()
                if (purchaseAmount % 1000 == 0) {
                    return purchaseAmount
                }
                Error.notValidPurchaseAmount()
            } catch (e: NumberFormatException) {
                Error.NAN()
            }
        }
    }

    private fun readWinningNumbers(): List<Int> {
        while (true) {
            try {
                val winningNumberString = Input.readWinningNumbers()
                val winningNumbers = ArrayList<Int>()
                val uniqueNumbers = HashSet<Int>()
                val trigger = validateWinningNumbers(winningNumberString, winningNumbers, uniqueNumbers)

                if (winningNumbers.size == 6) {
                    return winningNumbers
                }
                if (trigger == 1) {
                    Error.notValidWinningNumberLength()
                }
            } catch (e: NumberFormatException) {
                Error.NAN()
            }
        }
    }

    private fun validateWinningNumbers(
            winningNumberString: String,
            winningNumbers: MutableList<Int>,
            uniqueNumbers: MutableSet<Int>
    ): Int {
        var trigger = 1
        val winningNumberStringArray = winningNumberString.split(",".toRegex()).toTypedArray()
        for (number in winningNumberStringArray) {
            val num = number.toInt()
            if (uniqueNumbers.contains(num)) {
                Error.duplicateWinningNumber()
                trigger = 0
            } else if (num < 1 || num > 45) {
                Error.notValidWinningNumber()
                trigger = 0
            } else {
                winningNumbers.add(num)
                uniqueNumbers.add(num)
            }
        }
        return trigger
    }

    private fun readBonusNumber(): Int {
        while (true) {
            try {
                val bonusNumberString = Input.readBonusNumber()
                val bonusNumber = bonusNumberString.toInt()
                if (1 <= bonusNumber && bonusNumber <= 45) {
                    return bonusNumber
                }
                Error.notValidBonusNumber()
            } catch (e: NumberFormatException) {
                Error.NAN()
            }
        }
    }
}
