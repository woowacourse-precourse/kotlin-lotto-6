package lotto

import kotlin.IllegalArgumentException

class View(
    private val printer: Printer = Printer,
    private val reader: Reader = Reader
) {
    private fun inputPurchase(): Purchase {
        while (true) {
            try {
                val amount = reader.inputInt()
                return Purchase(amount = amount)
            } catch (e: IllegalArgumentException) {
                printInputError(e.message)
            }
        }
    }

    private fun inputWinningNumber(): List<Int> {
        while (true) {
            try {
                val numbers = reader.inputIntList(WINNING_NUMBER_DELIMITER)
                WinningNumber.validate(numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                printInputError(e.message)
            }
        }
    }

    private fun inputBonusNumber(winningNumber: List<Int>): Int {
        while (true) {
            try {
                val bonusNumber = reader.inputInt()
                WinningNumber.validate(winningNumber, bonusNumber)
                return bonusNumber
            } catch (e: IllegalArgumentException) {
                printInputError(e.message)
            }
        }
    }

    private fun printInputError(message: String? = null) {
        Printer.error(message ?: Message.InvalidInputError.toString())
    }

    private fun printWinningResult(purchase: Purchase, winningNumber: WinningNumber) {
        val lottos = purchase.lottos
        val results = lottos.map { winningNumber.check(it) }
        val profitPercentage = purchase.calculateProfitPercentage(results)
        printer.print(winnings = results, profitPercentage = profitPercentage)
    }

    fun run() {
        printer.print(Message.InputMoneyAmount)
        val purchase = inputPurchase()
        printer.print(purchase)

        printer.print(Message.InputWinningNumber)
        val winningNumber = inputWinningNumber()
        printer.printEmptyLine()

        printer.print(Message.InputBonusNumber)
        val bonusNumber = inputBonusNumber(winningNumber)
        printer.printEmptyLine()

        printWinningResult(purchase, WinningNumber(numbers = winningNumber, bonus = bonusNumber))
    }

    companion object {
        private const val WINNING_NUMBER_DELIMITER = ','
    }
}
