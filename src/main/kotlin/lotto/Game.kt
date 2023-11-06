package lotto

import camp.nextstep.edu.missionutils.Console
import camp.nextstep.edu.missionutils.Randoms

class Game private constructor(
    private val calculator: Calculator = Calculator(),
    private val printer: Printer = Printer()
) {

    fun purchaseLotto(): Int {
        printer.printEnterPurchase()
        val input = Console.readLine()
        return calculator.calculateLottoAvailableForPurchase(input)
    }

    fun createLottoNumber() {
        val purchaseLottoNumber = purchaseLotto()
        print(purchaseLottoNumber)

        val lottery = mutableListOf<Lotto>()
        repeat(purchaseLottoNumber) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            lottery.add(Lotto(numbers))
        }
    }

}