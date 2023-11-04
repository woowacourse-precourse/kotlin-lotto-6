package lotto.view

import lotto.model.Lotto
import lotto.model.Winner
import lotto.util.InputUtil
import lotto.util.OutputUtil
import java.util.*

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

    fun showWinningDetails(winningMap: EnumMap<Winner, Int>, earningRate: Double) {
        with (OutputUtil) {
            printWinningDetails(winningMap)
            printEarningRate(earningRate)
        }
    }
}