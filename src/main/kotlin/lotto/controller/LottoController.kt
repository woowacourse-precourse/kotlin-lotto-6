package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView
class LottoController(
    private val inputView: InputView=InputView(),
    private val outputView: OutputView=OutputView()
) {
    fun lottoGameStarter() {
        val lotto=moneyInput()
        val lottoNumbers=LottoNumberGenerator().lottoNumberCreation(lotto)
        outputView.lottoNumbersView(lottoNumbers)

        val rightLottoNumber=rightLottoNumberInput()

        var bonusNumber=bonusLottoNumberInput(rightLottoNumber)

        val compareResult=LottoCompare(bonusNumber,rightLottoNumber,lottoNumbers)

        outputView.lottoCompareResult(compareResult)
        outputView.lottoProfit(ProfitCalculation().profit(compareResult,lotto))
    }
    private fun moneyInput():Int {
        outputView.lottoPurchaseMessage()
        val money = inputView.lottoPurchase()
        try{
            PurchaseMoneyVerification(money)
        }catch (e:IllegalArgumentException){
            println(e.message)
            return moneyInput()
        }
        var lotto=(money.toInt())/1000
        outputView.lottoPurchaseConfirm(lotto)
        return lotto
    }
    private fun rightLottoNumberInput(): List<Int> {
        outputView.rightLottoNumberMessage()
        val rightLottoNumber = inputView.inputRightLottoNumber()
        try {
            Lotto(rightLottoNumber)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return rightLottoNumberInput()
        }
        return rightLottoNumber
    }
    private fun bonusLottoNumberInput(rightLottoNumber:List<Int>):Int {
        outputView.bonusLottoNumberMessage()
        val bonusNumber=inputView.inputBonusNumber()
        try {
            BonusNumberVerification(bonusNumber,rightLottoNumber)
        } catch (e:IllegalArgumentException){
            println(e.message)
            return bonusLottoNumberInput(rightLottoNumber)
        }
        return bonusNumber
    }

}