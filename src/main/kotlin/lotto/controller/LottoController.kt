package lotto.controller

import lotto.model.LottoTicket
import lotto.util.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    private val lottoGenerator = LottoGenerator()
    private val lottoTicket = LottoTicket()
    private var purchaseCount = 0

    fun run() {
        gameInit()
    }

    private fun gameInit() {
        settingPurchaseCount()
        publishLottoTicket()
    }

    private fun settingPurchaseCount() {
        outputView.printGameStartMessage()
        purchaseCount = getPurchaseCount()
        println() //예제 출력과 같게 하기 위해 공백 추가
    }

    private fun getPurchaseCount(): Int {
        val userInputPrice = inputView.getValidateUserInput()
        return userInputPrice / 1000
    }

    private fun publishLottoTicket() {
        outputView.printPurchaseCount(purchaseCount)
        repeat(purchaseCount) {
            val numbers = lottoGenerator.getSortedNumbers()
            lottoTicket.addNumbers(numbers)
        }
        outputView.printLottoTicket(lottoTicket)
    }
}