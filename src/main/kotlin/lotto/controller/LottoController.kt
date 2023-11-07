package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.RankGenerator
import lotto.domain.model.*
import lotto.domain.model.WinningLotto
import lotto.exception.IllegalBonusNumberException
import lotto.exception.IllegalPurchaseAmountException
import lotto.exception.IllegalWinningNumberException
import lotto.view.InputView
import lotto.view.OutputView

class LottoController() {
    fun start() {
        val purchase = getPurchase()
        val winningLotto = getWinningLotto()
        val lottos = LottoGenerator().make(purchase)
        val lottoResult = RankGenerator.getLottoResults(lottos, winningLotto)

    fun make() {
        val purchase = Purchase(getPurchaseAmount())
        val winningLotto = WinningLotto(Lotto(getWinningNumber()), getBonusNumber())
        OutputView.printLottos(purchase)
        OutputView.printLottos(purchase, lottos)
        OutputView.printReport(RankGenerator.make(lottos, winningLotto))
    }

        String.format("%.1f", lottoResult.calculatePerformance(purchase))

    private fun getPurchase() = Purchase(getPurchaseAmount())

    private fun getWinningLotto() = WinningLotto(Lotto(getWinningNumber()), getBonusNumber())

    private fun getPurchaseAmount(): Int {
        try {
            return InputView.inputPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            throw IllegalPurchaseAmountException()
        }
    }

    private fun getWinningNumber(): List<Int> {
        try {
            return InputView.inputWinningNumber()
        } catch (e: IllegalArgumentException) {
            throw IllegalWinningNumberException()
        }
    }

    private fun getBonusNumber(): Int {
        try {
            return InputView.inputBonusNumber()
        } catch (e: IllegalArgumentException) {
            throw IllegalBonusNumberException()
        }
    }
}
