package lotto.controller

import lotto.model.User
import lotto.model.WinResult
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView
import net.bytebuddy.asm.Advice.OffsetMapping.Factory.Illegal

class LottoController(private val inputView: InputView = InputView(),private val outPutView : OutputView = OutputView()) {

    private val user = User()
    private val winningLotto = WinningLotto()
    private val winResult = WinResult(user,winningLotto)
    fun run(){
        outPutView.printInputPrice()
        inputPrice()
        outPutView.printBuyLotto(user.price)
        buyLotto()
        outPutView.printUserLotto(user.lottoes)
        outPutView.printInputLuckyNumber()
        inputLuckyNumber()
        outPutView.printInputBonusNumber()
        inputBonusNumber()
        outPutView.printWinStatisticsMessage()
        calculateResult()
        outPutView.printWinStatisticsResult(winResult.placeResult)
        calculateEarningRate()
        outPutView.printTotalEarningRate(winResult.earningRate)
    }
    private fun inputPrice(){
        user.setPrice(inputView.inputPrice())
    }
    private fun buyLotto(){
        user.buyLotto()
    }
    private fun inputLuckyNumber(){
        winningLotto.setLuckyNumbers(inputView.inputLuckyNumber())
    }
    private fun inputBonusNumber(){
        try {
            winningLotto.setBonusNumber(inputView.inputBonusNumber())
        } catch (e : IllegalArgumentException){
            println(e.message)
            inputBonusNumber()
        }
    }
    private fun calculateResult(){
        winResult.calculateResult()
    }
    private fun calculateEarningRate(){
        winResult.calculateEarningRate()
    }
}