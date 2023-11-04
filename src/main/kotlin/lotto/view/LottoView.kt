package lotto.view

import lotto.model.Lotto
import lotto.util.InputUtil
import lotto.util.OutputUtil

class LottoView {
    fun showBuyViewAndReturnMoney(): Int {
        OutputUtil.printInputMoney()
        return InputUtil.inputMoney()
    }

    fun showAndReturnWinningNumber(): Lotto {
        OutputUtil.printInputWinningNumber()
        return InputUtil.inputWinningNumber()
    }

    fun showAndReturnBonusNumber(winningNumber: Lotto): Int {
        OutputUtil.printInputBonusNumber()
        return InputUtil.inputBonusNumber(winningNumber)
    }

    fun showPurchasedLottoList(purchasedLottoList: List<Lotto>) {
        OutputUtil.printPurchasedLottoList(purchasedLottoList)
    }
}