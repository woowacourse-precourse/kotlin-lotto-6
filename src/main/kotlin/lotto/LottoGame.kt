package lotto

import lotto.controller.LottoGameController

class LottoGame {
    fun start() {
        LottoGameController().apply {
            showPurchaseAmountInputView()
            showLottoView()
            showWinnerNumberInputView()
            showBonusNumberInputView()
            showLottoResultView()
        }
    }
}