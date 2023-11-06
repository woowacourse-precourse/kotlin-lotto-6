package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.validator.InputValidator

import lotto.domain.LottoShop
import lotto.domain.Lottos
import lotto.domain.Money

fun main() {
    val lottos = generateLottos()
    OutputView.outputLottos(lottos)
}

private fun generateLottos(): Lottos {
    return try {
        val money = getInputPurchaseAmount()
        LottoShop.buyLottos(money)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        generateLottos()
    }
}

private fun getInputPurchaseAmount(): Money {
    return try {
        val input = InputView.inputPurchaseAmount()
        InputValidator.validateInputPurchaseAmount(input)
        Money(input.toInt())
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getInputPurchaseAmount()
    }
}