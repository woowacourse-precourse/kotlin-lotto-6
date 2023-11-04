package lotto

class View(
    private val printer: Printer = Printer,
    private val reader: Reader = Reader
) {
    private fun inputPurchase(): Purchase {
        printer.print(Message.InputMoneyAmount)
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

    fun run() {
        val purchase = inputPurchase()
        printer.print(purchase)
    }
}
