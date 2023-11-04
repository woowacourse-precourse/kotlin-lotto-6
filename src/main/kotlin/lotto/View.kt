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
            try {
                return Purchase(amount = amount)
            } catch (e: Exception) {
                printer.error(e.message ?: Message.InvalidInputError.toString())
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
            try {
                WinningNumber.validate(numbers)
            } catch (e: Exception) {
                printer.error(e.message ?: Message.InvalidInputError.toString())
                continue
            }
            return numbers
        }
    }

    private fun inputBonusNumber(winningNumber: List<Int>): Int {
        while (true) {
            val bonusNumber = reader.inputIntOrNull()
            if (bonusNumber == null) {
                printer.error(Message.NotNumberOrOverflow)
                continue
            }
            try {
                WinningNumber.validate(winningNumber, bonusNumber)
            } catch (e: Exception) {
                printer.error(e.message ?: Message.InvalidInputError.toString())
                continue
            }
            return bonusNumber
        }
    }

    fun run() {
        printer.print(Message.InputMoneyAmount)
        val purchase = inputPurchase()
        printer.print(purchase)

        printer.print(Message.InputWinningNumber)
        val winningNumber = inputWinningNumber()
        printer.println()

        printer.print(Message.InputBonusNumber)
        val bonusNumber = inputBonusNumber(winningNumber)
        printer.println()
    }

    companion object {
        private const val WINNING_NUMBER_DELIMITER = ','
    }
}
