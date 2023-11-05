package lotto.controller

import lotto.model.*
import lotto.util.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

class LottoController(private val inputView: InputView, private val outputView: OutputView) {
    private val lottoGenerator = LottoGenerator()
    private val lottoTicket = LottoTicket()
    private lateinit var purchaseCount: PurchaseCount
    private lateinit var lotto: Lotto
    private lateinit var bonus: Bonus
    private lateinit var lottoResult: LottoResult
    private val lottoRankings = LottoRankings()
    private val lottoProfit = LottoProfit()

    fun run() {
        gameInit()
        settingLotto()
        settingBonusNumber()
        checkWinningNumbers()
        showLottoStatistics()
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
            val userInputPrice = inputView.getValidIntegerInput()
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
        println() //예제 출력과 같게 하기 위해 공백 추가
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

    private fun settingBonusNumber() {
        outputView.printBonusLottoInfoMessage()
        bonusNumberPublish()
    }

    private fun bonusNumberPublish() {
        try {
            val userInput = inputView.getValidIntegerInput()
            val numbers = lotto.getWinningNumbers()
            bonus = Bonus(userInput)
            bonus.checkUniqueNumber(numbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            bonusNumberPublish()
        }
    }

    private fun checkWinningNumbers() {
        lottoResult = LottoResult(lotto.getWinningNumbers(), bonus.number)
        repeat(purchaseCount.count) { round ->
            val winning = lottoResult.calculateRanking(lottoTicket.numbers[round])
            lottoRankings.addRanking(winning)
        }
    }

    private fun showLottoStatistics() {
        outputView.printLottoRankings(lottoRankings)
        lottoProfit.calculateRate(lottoRankings.rank, purchaseCount.count * 1000)
        outputView.printLottoProfitRate(lottoProfit)
    }
}