package lotto

fun main() {
    val cashier = Cashier()
    val machine = LottoMachine()

    val purchases = cashier.purchase()
    val winningNumbers = machine.drawNumbers()
    machine.printResult(purchases, winningNumbers)
}
