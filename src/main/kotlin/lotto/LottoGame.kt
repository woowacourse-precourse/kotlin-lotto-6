package lotto

import lotto.domain.Purchaser

class LottoGame {


    fun gameStart() {
        purchaseLotto()
    }

    private fun purchaseLotto() {
        val purchaser: Purchaser = checkException { Purchaser(InputManager.getPurchaseInput()) }
    }

    private fun <T> checkException(createClass: () -> T): T = runCatching { createClass() }
        .getOrElse {
            println(it.message)
            checkException(createClass)
        }
}