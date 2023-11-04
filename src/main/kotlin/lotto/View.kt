package lotto

class View(
    private val printer: Printer = Printer,
    private val reader: Reader = Reader
) {
    private fun inputPurchase(): Purchase {
        while (true) {
            val amount = reader.inputIntOrNull()
            if (amount == null) {
                printer.error(Message.NotNumberOrOverflow)
                continue
            }
            runOrPrintErrorIfThrow {
                return Purchase(amount = amount)
            }
        }
    }

    private fun inputWinningNumber(): List<Int> {
        while (true) {
            val numbers = reader.inputIntegerListOrNull(WINNING_NUMBER_DELIMITER)
            if (numbers == null) {
                printer.error(Message.NotNumberOrOverflow)
                continue
            }
            runOrPrintErrorIfThrow {
                WinningNumber.validate(numbers)
                return numbers
            }
        }
    }

    private fun inputBonusNumber(winningNumber: List<Int>): Int {
        while (true) {
            val bonusNumber = reader.inputIntOrNull()
            if (bonusNumber == null) {
                printer.error(Message.NotNumberOrOverflow)
                continue
            }
            runOrPrintErrorIfThrow {
                WinningNumber.validate(winningNumber, bonusNumber)
                return bonusNumber
            }
        }
    }

    private inline fun runOrPrintErrorIfThrow(
        defaultMessage: Message = Message.InvalidInputError,
        block: () -> Unit
    ) {
        try {
            block()
        } catch (e: Exception) {
            printer.error(e.message ?: defaultMessage.toString())
        }
    }

    private fun printWinningResult(purchase: Purchase, winningNumber: WinningNumber) {
        val lottos = purchase.lottos
        val results = lottos.map { winningNumber.check(it) }
        val profitPercentage = purchase.calculateProfitPercentage(results)
        printer.print(results = results, profitPercentage = profitPercentage)
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
