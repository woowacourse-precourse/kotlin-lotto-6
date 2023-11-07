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
        outputView.rightLottoNumbersView(lottoNumbers)

        outputView.rightLottoNumberMessage()
        val correctLottoNumber=inputView.inputRightLottoNumber()
        Lotto(correctLottoNumber)

        outputView.bonusLottoNumberMessage()
        var bonusNumber=inputView.inputBonusNumber()
        BonusNumberVerification(bonusNumber,correctLottoNumber)

        val compareResult=LottoCompare(bonusNumber,correctLottoNumber,lottoNumbers)

        outputView.lottoCompareResult(compareResult)

        outputView.lottoProfit(ProfitCalculation().profit(compareResult,moneyInput))


    }

    fun gameProgress(){

    }
}