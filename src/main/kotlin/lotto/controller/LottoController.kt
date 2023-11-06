package lotto.controller

import lotto.domain.LottoStore
import lotto.validator.WinNumbersValidator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {
        val lottoStore = inputPrice()
        printTickets(lottoStore)
        val winNumbers = drawWinNumbers()
    }

    private fun inputPrice(): LottoStore {
        var attempts = 0
        while (attempts <= 5) {
            try {
                val purchasePrice = InputView.promptForPurchasePrice().also { println() }
                return LottoStore(purchasePrice)
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    private fun drawWinNumbers(): List<String> {
        var attempts = 0
        while (attempts <= 5) {
            try {
                val winNumbers = InputView.promptForWinNumbers().also { println() }
                WinNumbersValidator(winNumbers)
                return winNumbers
            } catch (e: IllegalArgumentException) {
                println(e.message)
                attempts++
            }
        }

        throw IllegalArgumentException("입력에 여러 차례 실패했습니다. 프로그램을 종료합니다.")
    }

    private fun printTickets(lottoStore: LottoStore) {
        OutputView.printPurchaseCount(lottoStore.getNumberOfTickets())
        val tickets = lottoStore.sellTickets()
        OutputView.printTickets(tickets).also { println() }
    }
}
