package lotto.controller

import lotto.model.Lotto
import lotto.model.PurchaseCount
import lotto.model.LottoTicket
import lotto.util.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    private val lottoGenerator = LottoGenerator()
    private val lottoTicket = LottoTicket()
    private lateinit var purchaseCount: PurchaseCount
    private lateinit var lotto: Lotto

    fun run() {
        gameInit()
        settingLotto()
    }

    private fun gameInit() {
        settingPurchaseCount()
        publishLottoTicket()
        printLottoTicket()
        println() //예제 출력과 같게 하기 위해 공백 추가
    }

    private fun settingPurchaseCount() {
        outputView.printGameStartMessage()
        getPurchaseCount()
        println() //예제 출력과 같게 하기 위해 공백 추가
    }

    private fun getPurchaseCount() {
        try {
            val userInputPrice = inputView.getUserInput()
            purchaseCount = PurchaseCount(userInputPrice)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseCount()
        }
    }

    private fun publishLottoTicket() {
        repeat(purchaseCount.count) {
            val numbers = lottoGenerator.getSortedNumbers()
            lottoTicket.addNumbers(numbers)
        }
    }

    private fun printLottoTicket() {
        outputView.printPurchaseCount(purchaseCount.count)
        outputView.printLottoTicket(lottoTicket)
    }

    private fun settingLotto() {
        outputView.printLottoPurchaseInfoMessage()
        lottoPublish()
    }

    private fun lottoPublish() {
        try {
            val userInput = inputView.getValidLottoInput()
            lotto = Lotto(userInput)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            lottoPublish()
        }
    }
}