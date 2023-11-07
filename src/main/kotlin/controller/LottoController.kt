package controller

import domain.chance.Chance
import domain.lotto.Lotto
import domain.lotto.NumberPicker
import domain.result.LottoResult
import lotto.domain.purchase.Money
import lotto.view.InputView
import view.ResultView

object LottoController {

    private var money: Money
    private var chance: Chance
    private var numberPicker: NumberPicker

    init {
        money = getUserAmount()
        chance = getChance(money)
        numberPicker = getNumberPicker(chance.getChanceTimes())
    }

    fun startGame() {
        ResultView.printNumberOfLottiesPurchased(chance)

        val pickedLotties = numberPicker.getRandomNumbers()
        val sortedLotties = pickedLotties.map {
            Lotto(it).getSortedNumbers()
        }

        ResultView.printPurchasedLotties(sortedLotties)

        val lottoResult = getLottoResult(sortedLotties)

    }

    private fun getUserAmount(): Money = Money(InputView.inputPurchaseAmount())

    private fun getChance(money: Money) = Chance(money)

    private fun getNumberPicker(times: Int) = NumberPicker(times)

    private fun getLottoResult(lotties: List<List<Int>>): LottoResult {
        val winningNumbers = InputView.inputWinningNumberList()
        val bonusNumber = InputView.inputBonusNumber()

        return LottoResult(lotties, winningNumbers, bonusNumber)
    }
}