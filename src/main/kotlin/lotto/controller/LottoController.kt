package lotto.controller

import lotto.model.*
import lotto.util.Constants.LOTTO_PRICE
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private val lottoTicket = LottoTicket()
    private lateinit var purchaseCount: PurchaseCount
    private lateinit var lotto: Lotto
    private lateinit var bonus: Bonus
    private lateinit var lottoResult: LottoResult
    private val lottoRankings = LottoRankings()

    fun run() {
        gameInit()
        settingWinningNumber()
        checkWinningNumbers()
        showLottoStatistics()
    }

    private fun gameInit() {
        settingPurchaseCount()
        lottoTicket.lottoTicketPublish(purchaseCount.count)
        printLottoTicket()
    }

    private fun settingWinningNumber() {
        settingLotto()
        settingBonusNumber()
    }

    private fun settingLotto() {
        outputView.printLottoPurchaseInfoMessage()
        lottoPublish()
    }

    private fun settingBonusNumber() {
        outputView.printBonusLottoInfoMessage()
        bonusNumberPublish()
    }

    private fun checkWinningNumbers() {
        lottoResult = LottoResult(lotto.getWinningNumbers(), bonus.number)
        repeat(purchaseCount.count) { round ->
            val winning = lottoResult.calculateRanking(lottoTicket.numbers[round])
            lottoRankings.addRanking(winning)
        }
    }

    private fun settingPurchaseCount() {
        outputView.printGameStartMessage()
        getPurchaseCount()
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

    private fun printLottoTicket() {
        outputView.printPurchaseCount(purchaseCount.count)
        outputView.printLottoTicket(lottoTicket)
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

    private fun showLottoStatistics() {
        val lottoProfit = LottoProfit(lottoRankings.rank, purchaseCount.count * LOTTO_PRICE)
        outputView.printLottoRankings(lottoRankings)
        outputView.printLottoProfitRate(lottoProfit)
    }
}