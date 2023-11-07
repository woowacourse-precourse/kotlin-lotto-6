package lotto.controller

import lotto.model.*
import lotto.domain.*
import lotto.utils.Constants
import lotto.utils.Messages
import lotto.view.InputView
import lotto.view.OutputView

class LottoManager(private val inputView: InputView, private val outputView: OutputView) {
    fun run() {
        val ticket = purchaseLotto()
        val answerLottoNumbers = answerLotto(ticket)
        val userWinningNumbers = userWinningLotto()
        val lottos = Lotto(userWinningNumbers)
        val bonusNumber = bonus(userWinningNumbers)
        val results = rankOfLotto(lottos, answerLottoNumbers, bonusNumber)
        val profitPercentage = yieldLotto(results, ticket)
        outputResults(results, profitPercentage)
    }

    private fun purchaseLotto(): Int {
        outputView.showInputBuyPriceMessage()
        val lottoPurchase = LottoPurchase()
        val amount = lottoPurchase.buyLotto()
        val ticket = lottoPurchase.calculateTicket(amount)
        outputView.showBuyTicketMessage(ticket)

        return ticket
    }

    private fun answerLotto(ticket: Int): MutableList<Lotto> {
        val lottoWrapper = LottoWrapper()
        val lottoList = lottoWrapper.repeatLottoNumbers(ticket)

        outputView.showLottoNumbers(lottoList)
        return lottoList
    }

    private fun userWinningLotto(): List<Int> {
        val lottoWinning = LottoWinning()
        outputView.showInputMyNumbersMessage()
        return lottoWinning.createWinningLotto()
    }

    private fun bonus(userWinningNumbers: List<Int>): Int {
        outputView.showInputBonusNumberMessage()
        val bonusNumber = inputView.inputBonusNumber().getBonus()
        validateDuplicateBonusNumber(userWinningNumbers, bonusNumber)
        return bonusNumber
    }

    private fun rankOfLotto(lotto: Lotto, answerLottoNumbers: MutableList<Lotto>, bonusNumber: Int): MutableMap<Prize, Int> {
        outputView.showWinningStatisticsMessages()
        val ranks = RankManager()
        var results = mutableMapOf<Prize, Int>()
        answerLottoNumbers.forEach {
            results = ranks.rankManager(lotto, it.getLotto(),bonusNumber)
        }
        return results
    }

    private fun yieldLotto(results: MutableMap<Prize, Int>, ticket: Int): Double {
        val yield = LottoYield()
        return yield.calculateLottoYield(results, ticket * Constants.THOUSAND_PRICE)
    }

    private fun outputResults(results: MutableMap<Prize, Int>, profitPercentage: Double) {
        outputView.printResults(results)
        outputView.printProfitPercentage(profitPercentage)
    }

    fun validateDuplicateBonusNumber(userWinningNumbers: List<Int>, bonusNumber: Int) {
        require(!userWinningNumbers.contains(bonusNumber)) {
            "${Messages.ERROR_MESSAGE} ${Messages.MY_NUMBERS_DUPLICATED_MESSAGE}"
        }
    }
}