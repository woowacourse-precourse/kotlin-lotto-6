package lotto.view

import lotto.util.Printer

class OutputView {

    private val printer = Printer

    fun printInputMoney() {
        printer.printInputMoney()
    }

    fun printInputNumbers() {
        printer.printInputNumbers()
    }
    fun printInputBonus() {
        printer.printInputBonus()
    }
}