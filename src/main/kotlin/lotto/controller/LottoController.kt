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
        val price = inputView.inputPrice()
        outPutView.printBuyLotto(price)
        user.buyLotto(price)
        outPutView.printUserLotto(user.lottoes)
        outPutView.printInputLuckyNumber()
        winningLotto.setLuckyNumbers(inputView.inputLuckyNumber())
        outPutView.printInputBonusNumber()
        winningLotto.setBonusNumber(inputView.inputBonusNumber(winningLotto.luckyNumbers))
    }
}