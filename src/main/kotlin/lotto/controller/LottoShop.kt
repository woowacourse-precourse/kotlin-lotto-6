package lotto.controller

import lotto.view.InputView

class LottoShop {

    private val inputView = InputView()

    fun buyLotto() {
        inputView.buyMessage()
        val price = inputView.inputView()
    }
}