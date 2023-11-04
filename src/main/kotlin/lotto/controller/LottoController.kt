package lotto.controller

import lotto.model.BonusNumberVerification
import lotto.model.Lotto
import lotto.model.PurchaseMoneyVerification
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView=InputView(),
    private val outputView: OutputView=OutputView()
) {

    fun lottoGameStarter(){



        outputView.lottoPurchaseMessage()
        val lotto=PurchaseMoneyVerification().inputMoneyCheck(inputView.lottoPurchase())


        outputView.lottoPurchaseConfirm(lotto)


        outputView.rightLottoNumberMessage()
        val correctLottoNumber=inputView.inputRightLottoNumber()
        val lottoNumber=Lotto(correctLottoNumber)


        outputView.bonusLottoNumberMessage()
        var bonusNumber=inputView.inputBonusNumber()

        BonusNumberVerification(bonusNumber,correctLottoNumber)

    }

    fun gameProgress(){

    }
}