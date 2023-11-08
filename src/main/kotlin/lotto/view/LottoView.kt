package lotto.view

import lotto.model.Lotto
import lotto.model.Winner
import lotto.util.InputUtil
import lotto.util.OutputUtil
import lotto.util.OutputUtil.printExceptionMessage
import java.util.*

class LottoView {
    fun showBuyViewAndReturnMoney(): Int {
        OutputUtil.printInputMoney()
        return try {
            InputUtil.inputMoney()
        } catch (e: IllegalArgumentException) {
            printExceptionMessage(e.message)
            showBuyViewAndReturnMoney()
        }
    }

    fun showAndReturnWinningNumber(): Lotto {
        OutputUtil.printInputWinningNumber()
        return try {
            InputUtil.inputWinningNumber()
        } catch (e: IllegalArgumentException) {
            printExceptionMessage(e.message)
            showAndReturnWinningNumber()
        }
    }

    fun showAndReturnBonusNumber(winningNumber: Lotto): Int {
        OutputUtil.printInputBonusNumber()
        return try {
            InputUtil.inputBonusNumber(winningNumber)
        } catch (e: IllegalArgumentException) {
            printExceptionMessage(e.message)
            showAndReturnBonusNumber(winningNumber)
        }
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