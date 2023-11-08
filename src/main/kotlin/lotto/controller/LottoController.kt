package lotto.controller

import lotto.model.Message
import lotto.view.Printer
import lotto.model.Purchase
import lotto.view.Reader
import lotto.model.WinningNumber
import kotlin.IllegalArgumentException

class LottoController(
    private val printer: Printer = Printer,
    private val reader: Reader = Reader
) {
    private fun inputPurchase(): Purchase = inputUntilValid {
        printer.print(Message.InputMoneyAmount)
        val amount = inputInt()

        return Purchase(amount).also { printer.print(it) }
    }

    private fun inputNormalWinningNumbers(): List<Int> = inputUntilValid {
        printer.print(Message.InputNormalWinningNumber)
        val numbers = inputIntList(WINNING_NUMBER_DELIMITER)
        WinningNumber.validate(numbers)
        printer.printEmptyLine()

        return numbers
    }

    private fun inputBonusWinningNumber(normalNumbers: List<Int>): Int = inputUntilValid {
        printer.print(Message.InputBonusWinningNumber)
        val bonus = inputInt()
        WinningNumber.validate(normalNumbers, bonus)
        printer.printEmptyLine()

        return bonus
    }

    private inline fun <T> inputUntilValid(block: Reader.() -> T): T {
        while (true) {
            try {
                return reader.block()
            } catch (e: IllegalArgumentException) {
                printer.error(e.message ?: Message.InvalidInputError.toString())
            }
        }
    }

    private fun input(): Pair<Purchase, WinningNumber> {
        val purchase = inputPurchase()
        val normalWinningNumbers = inputNormalWinningNumbers()
        val bonusNumber = inputBonusWinningNumber(normalWinningNumbers)

        return purchase to WinningNumber(normalWinningNumbers, bonusNumber)
    }

    fun run() {
        val (purchase: Purchase, winningNumber: WinningNumber) = input()
        val statics = purchase.check(winningNumber)
        printer.print(statics)
    }

    companion object {
        private const val WINNING_NUMBER_DELIMITER = ','
    }
}
