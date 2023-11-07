package lotto.controller

import lotto.domain.Chance
import lotto.domain.Lotto
import lotto.domain.NumberPicker
import lotto.domain.LottoResult
import lotto.domain.Money
import lotto.view.InputView
import lotto.view.ResultView

class LottoController {

    private val inputView = InputView()
    private val resultView = ResultView()

    private val money = getUserAmount()
    private val chance = getChance(money)
    private val numberPicker = getNumberPicker(chance.getChanceTimes())

    fun startGame() {
        resultView.printNumberOfLottiesPurchased(chance)

        val pickedLotties = numberPicker.getRandomNumbers()
        val sortedLotties = pickedLotties.map {
            Lotto(it).sortedRandomNumbers()
        }
        resultView.printPurchasedLotties(sortedLotties)

        val lottoResult = getLottoResult(sortedLotties)
        val finalResult = getFinalResult(lottoResult)
        resultView.printFinalResult(finalResult)
    }

    private fun getUserAmount(): Money = Money(inputView.inputPurchaseAmount())

    private fun getChance(money: Money) = Chance(money)

    private fun getNumberPicker(times: Int) = NumberPicker(times)

    private fun getLottoResult(lotties: List<List<Int>>): LottoResult {
        val winningNumbers = inputView.inputWinningNumberList()
        val bonusNumber = inputView.inputBonusNumber(winningNumbers)

        return LottoResult(lotties, winningNumbers, bonusNumber)
    }

    private fun getFinalResult(lottoResult: LottoResult) = lottoResult.getFinalResult()
}