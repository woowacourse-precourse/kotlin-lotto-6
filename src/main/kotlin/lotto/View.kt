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

    private fun inputNormalWinningNumbers(): List<Int> {
        while (true) {
            try {
                val numbers = reader.inputIntList(WINNING_NUMBER_DELIMITER)
                WinningNumber.validate(normalNumbers = numbers)
                return numbers
            } catch (e: IllegalArgumentException) {
                printInputError(e.message)
            }
        }
    }

    private fun inputBonusWinningNumber(normalNumbers: List<Int>): Int {
        while (true) {
            try {
                val bonus = reader.inputInt()
                WinningNumber.validate(normalNumbers = normalNumbers, bonusNumber = bonus)
                return bonus
            } catch (e: IllegalArgumentException) {
                printInputError(e.message)
            }
        }
    }

    private fun printInputError(message: String? = null) {
        Printer.error(message ?: Message.InvalidInputError.toString())
    }

    private fun printWinningResult(purchase: Purchase, winningNumber: WinningNumber) {
        val results = purchase.check(winningNumber)
        val profitPercentage = purchase.calculateProfitPercentage(results)
        printer.print(winnings = results, profitPercentage = profitPercentage)
    }

    private fun input(): Pair<Purchase, WinningNumber> {
        printer.print(Message.InputMoneyAmount)
        val purchase = inputPurchase()
        printer.print(purchase)

        printer.print(Message.InputNormalWinningNumber)
        val normalWinningNumbers = inputNormalWinningNumbers()
        printer.printEmptyLine()

        printer.print(Message.InputBonusWinningNumber)
        val bonusNumber = inputBonusWinningNumber(normalWinningNumbers)
        printer.printEmptyLine()

        return purchase to WinningNumber(normalWinningNumbers, bonusNumber)
    }

    fun run() {
        val (purchase: Purchase, winningNumber: WinningNumber) = input()
        printWinningResult(purchase, winningNumber)
    }

    companion object {
        private const val WINNING_NUMBER_DELIMITER = ','
    }
}
