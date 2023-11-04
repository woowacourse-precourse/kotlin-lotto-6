package lotto.controller

import lotto.model.User
import lotto.model.WinResult
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(private val inputView: InputView = InputView(),private val outPutView : OutputView = OutputView()) {

    private val user = User()
    private val winningLotto = WinningLotto()
    fun run(){
        outPutView.printInputPrice()
        user.setPrice(inputView.inputPrice())
        outPutView.printBuyLotto(user.price)
        user.buyLotto()
        outPutView.printUserLotto(user.lottoes)
        outPutView.printInputLuckyNumber()
        winningLotto.setLuckyNumbers(inputView.inputLuckyNumber())
        outPutView.printInputBonusNumber()
        winningLotto.setBonusNumber(inputView.inputBonusNumber(winningLotto.luckyNumbers))
        outPutView.printWinStatisticsMessage()
        val winResult = WinResult(user,winningLotto)
        winResult.calculateResult()
        outPutView.printWinStatisticsResult(winResult.placeResult)
        outPutView.printTotalEarningRate(winResult.calculateEarningRate())
    }
}