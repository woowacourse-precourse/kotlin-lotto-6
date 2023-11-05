package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView
import java.lang.IllegalArgumentException

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView
) {
    private val lottoTicket = LottoTicket()
    private lateinit var purchase: Purchase
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
        lottoTicket.lottoTicketPublish(purchase.count)
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
        repeat(purchase.count) { round ->
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
            purchase = Purchase(userInputPrice)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            getPurchaseCount()
        }
    }

    private fun printLottoTicket() {
        outputView.printPurchaseCount(purchase.count)
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
        val lottoProfit = LottoProfit(lottoRankings.rank, purchase.price)
        outputView.printLottoRankings(lottoRankings)
        outputView.printLottoProfitRate(lottoProfit)
    }
}