package lotto.controller

import lotto.domain.Lotto
import lotto.domain.LottoSalesOffice
import lotto.domain.WinnerDecider
import lotto.view.InputView
import lotto.view.OutputView

class Controller {

    private val inputView = InputView()
    private val outputView = OutputView()
    fun start() {
        val userLottos = buyLotto()
        showUserLottos(userLottos)
        showResultBoard(userLottos)


    }

    private fun buyLotto(): List<Lotto> {
        val lottoSalesOffice = LottoSalesOffice()
        return lottoSalesOffice.sellLotto(inputMoney().toInt())
    }

    private fun inputMoney(): String {
        outputView.printInputMoney()
        return inputView.readInput()
    }

    private fun showUserLottos(lottos: List<Lotto>) {
        for (lotto in lottos) {
            println(lotto.showLotto())
        }
    }


    private fun inputWinningLottoNumbers(): String {
        outputView.printInputWinningNumbers()
        return inputView.readInput()
    }

    private fun inputBonusNumber(): String {
        outputView.printInputBonusNumber()
        return inputView.readInput()
    }

    private fun showResultBoard(userLottos: List<Lotto>) {
        val winningLotto = inputWinningLottoNumbers()
        val bonusNumber = inputBonusNumber()
        val winnerDecider = WinnerDecider(winningLotto, bonusNumber,userLottos)
        winnerDecider.makeJudgement()

        outputView.printResultBoardHeader()
    }

}