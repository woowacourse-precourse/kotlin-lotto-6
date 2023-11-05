package lotto

import camp.nextstep.edu.missionutils.Console
class Game private constructor(
    private val calculator: Calculator = Calculator(),
    private val printer: Printer = Printer()
) {

    fun purchaseLotto(): Int {
        printer.printEnterPurchase()
        val input = Console.readLine()
        return calculator.calculateLottoAvailableForPurchase(input)
    }

}