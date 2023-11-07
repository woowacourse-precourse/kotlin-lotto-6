package lotto

import lotto.domain.LottoWallet
import lotto.domain.Purchaser
import lotto.view.InputManager

class LottoGame {


    fun gameStart() {
        val lottoWallet = purchaseLotto()
        println(lottoWallet)
    }

    private fun purchaseLotto(): LottoWallet {
        val purchaser: Purchaser = checkException { Purchaser(InputManager.getPurchaseInput()) }
        return purchaser.lottoWallet
    }

    private fun <T> checkException(createClass: () -> T): T = runCatching { createClass() }
        .getOrElse {
            println(it.message)
            checkException(createClass)
        }
}