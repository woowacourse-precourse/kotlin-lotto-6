package lotto.controller

import lotto.domain.LottoStore
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val numberOfTickets = inputPrice()
        printTickets(numberOfTickets)
    }

    private fun inputPrice(): Int {
        var attempts = 0
        while (attempts <= 5) {
            try {
                val purchasePrice = InputView.promptForPurchasePrice().also { println() }
                return LottoStore(purchasePrice).getNumberOfTickets()
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("가격 입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    private fun printTickets(numberOfTickets: Int) {
        OutputView.printPurchaseCount(numberOfTickets)

    }
}
