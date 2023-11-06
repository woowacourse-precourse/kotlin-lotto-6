package lotto.controller

import lotto.domain.Lotto
import lotto.domain.Validator
import lotto.utils.RandomUtils
import lotto.view.InputView

class LottoShop {

    private val inputView = InputView()
    private val validator = Validator()
    private val randomUtils = RandomUtils()

    fun buyLotto() {
        inputView.buyMessage()
        val price = inputView.inputView()
        validator.validatePrice(price)
        val lottoCount = price.toInt() / 1000
        repeat(lottoCount) {
            val numbers = randomUtils.pickLottoNum()
            val lotto: Lotto = Lotto(numbers.sorted())
            println(lotto)
        }
    }
}