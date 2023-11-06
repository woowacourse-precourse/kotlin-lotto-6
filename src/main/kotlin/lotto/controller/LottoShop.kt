package lotto.controller

import lotto.domain.Validator
import lotto.view.InputView

class LottoShop {

    private val inputView = InputView()
    private val validator = Validator()

    fun buyLotto() {
        inputView.buyMessage()
        val price = inputView.inputView()
        validator.validatePrice(price)
    }
}