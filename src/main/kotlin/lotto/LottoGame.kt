package lotto

import lotto.domain.Lotto
import lotto.domain.LottoWallet
import lotto.domain.Purchaser
import lotto.view.InputManager

class LottoGame {


    fun gameStart() {
        val lottoWallet = purchaseLotto()
        println(lottoWallet)
        getWinningLotto()
    }

    private fun purchaseLotto(): LottoWallet {
        val purchaser: Purchaser = checkException { Purchaser(InputManager.getPurchaseInput()) }
        return purchaser.lottoWallet
    }

    private fun getWinningLotto() {
        val winningNumber = checkException { Lotto(InputManager.getWinningNumber()) }
    }

    private fun <T> checkException(createClass: () -> T): T = runCatching { createClass() }
        .getOrElse {
            println(it.message)
            checkException(createClass)
        }
}