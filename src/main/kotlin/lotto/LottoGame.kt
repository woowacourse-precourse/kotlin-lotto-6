package lotto

import lotto.domain.Purchaser
import lotto.domain.WinningDetails
import lotto.domain.WinningLotto
import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoWallet
import lotto.view.InputManager

class LottoGame {

    fun gameStart() {
        val lottoWallet = purchaseLotto()
        println(lottoWallet)
        val winningLotto = getWinningLotto()
        val statistics = WinningDetails(winningLotto, lottoWallet)
        println(statistics.toString())
    }

    private fun purchaseLotto(): LottoWallet {
        val purchaser: Purchaser = checkException { Purchaser(InputManager.getPurchaseInput()) }
        return purchaser.lottoWallet
    }

    private fun getWinningLotto(): WinningLotto {
        val winningNumber = checkException { Lotto(InputManager.getWinningNumber()) }
        return checkException { WinningLotto(winningNumber, InputManager.getBonusNumber()) }
    }

    private fun <T> checkException(createClass: () -> T): T =
        try {
            createClass()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            createClass()
        }
}