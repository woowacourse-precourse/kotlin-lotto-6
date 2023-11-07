package lotto.controller

import lotto.Lotto
import lotto.domain.BuyLottos
import lotto.domain.CheckLottoNumber
import lotto.domain.Stats
import lotto.view.InputView
import lotto.view.OutputView

class Controller(private val inputView: InputView, private val outputView: OutputView) {
    var buyAmount : Int = 0
    lateinit var buyLottos: List<Lotto>
    lateinit var winningNumbers: List<Int>

    fun startGame() {
        buyLotto()
        getInputWinningNumbers()
    }

    fun buyLotto() {
        buyAmount = inputView.inputBuyAmount()
        buyLottos = BuyLottos().buyLottos(buyAmount)
        outputView.printBuyLottos(buyLottos)
    }

    fun getInputWinningNumbers() {
        winningNumbers = InputWinningNumbers()
        InputBonusNumber(winningNumbers)
    }

    fun InputWinningNumbers() : List<Int> {
        val winningNumbers = inputView.inputWinningNumbers()
        return winningNumbers
    }

    fun InputBonusNumber(winningNumbers: List<Int>) {
        val bonusNumber = inputView.inputBonusNumber(winningNumbers)
        val lottoStats = CheckLottoNumber(buyLottos, Lotto(winningNumbers), bonusNumber).checkLottoNumber()
        outputView.printLottoStats(lottoStats)
        outputView.printEarningRate(lottoStats, buyAmount)
    }

}