package lotto.controller

import lotto.model.*
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView=InputView(),
    private val outputView: OutputView=OutputView()
) {

    fun lottoGameStarter(){

        outputView.lottoPurchaseMessage()
        val moneyInput=inputView.lottoPurchase()
        val lotto=PurchaseMoneyVerification().inputMoneyCheck(moneyInput)
        outputView.lottoPurchaseConfirm(lotto)

        val lottoNumbers=LottoNumberGenerator().lottoNumberCreation(lotto)
        outputView.lottoNumbersView(lottoNumbers)

        outputView.rightLottoNumberMessage()
        val rightLottoNumber=inputView.inputRightLottoNumber()
        Lotto(rightLottoNumber)

        outputView.bonusLottoNumberMessage()
        var bonusNumber=inputView.inputBonusNumber()
        BonusNumberVerification(bonusNumber,rightLottoNumber)

        val compareResult=LottoCompare(bonusNumber,rightLottoNumber,lottoNumbers)

        outputView.lottoCompareResult(compareResult)

        outputView.lottoProfit(ProfitCalculation().profit(compareResult,lotto))

    }

}