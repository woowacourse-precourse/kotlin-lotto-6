package lotto.controller

import lotto.Lotto
import lotto.domain.BuyLottos
import lotto.domain.CheckLottoNumber
import lotto.domain.Stats
import lotto.view.InputView
import lotto.view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    private lateinit var buyLottos: List<Lotto>
    private lateinit var winningNumbers: List<Int>

    fun startGame() {
        val buyAmount = buyLotto()
        getWinningNumbers()
        val lottoStats = getLottoNumberStats(winningNumbers, getBonusNumber(winningNumbers))
        getEarningRate(lottoStats, buyAmount)
    }

    private fun buyLotto(): Int {
        val buyAmount = inputView.inputBuyAmount()
        buyLottos = BuyLottos().buyLottos(buyAmount)
        outputView.printBuyLottos(buyLottos)
        return buyAmount
    }

    private fun getWinningNumbers() {
        winningNumbers = inputView.inputWinningNumbers()
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int = inputView.inputBonusNumber(winningNumbers)


    private fun getLottoNumberStats(winningNumbers: List<Int>, bonusNumber: Int): Map<Stats, Int> {
        val lottoStats = CheckLottoNumber(buyLottos, Lotto(winningNumbers), bonusNumber).checkLottoNumberMatchedCount()
        outputView.printLottoStats(lottoStats)
        return lottoStats
    }

    private fun getEarningRate(lottoStats: Map<Stats, Int>, buyAmount: Int) =
        outputView.printEarningRate(lottoStats, buyAmount)

}