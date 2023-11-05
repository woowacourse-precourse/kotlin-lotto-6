package lotto.service

import lotto.model.Lotto
import lotto.model.LottoNumberGenerator
import lotto.model.User
import lotto.util.Constant.INPUT_PRICE_UNIT_ERROR_MESSAGE
import lotto.util.Constant.UNIT_PRICE
import lotto.view.InputView
import lotto.view.OutputView

class UserService(private val inputView: InputView = InputView(), private val outputView: OutputView = OutputView()) {

    private val lottoes: MutableList<Lotto> = mutableListOf()
    private var price = 0

    fun makeUser(): User {
        outputView.printInputPrice()
        inputPrice()
        outputView.printBuyLotto(price)
        buyLotto()
        outputView.printUserLotto(lottoes)
        return User(price, lottoes)
    }

    private fun inputPrice() {
        try {
            price = inputView.inputPrice()
            require(price % UNIT_PRICE == 0) { INPUT_PRICE_UNIT_ERROR_MESSAGE }
        } catch (e: IllegalArgumentException) {
            println(e.message)
            inputPrice()
        }
    }

    private fun buyLotto() {
        repeat(price / UNIT_PRICE) {
            lottoes.add(Lotto(LottoNumberGenerator.makeLottoNumber()))
        }
    }

}