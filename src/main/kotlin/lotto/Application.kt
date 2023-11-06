package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView
import lotto.validator.InputValidator

fun main() {
    val lottos = generateLottos()
    OutputView.outputLottos(lottos)

    val winningLotto = getWinningLotto()
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

private fun getWinningLotto(): Lotto {
    return try {
        val input = InputView.inputWinningLotto()
        InputValidator.validateInputWinningLotto(input)
        Lotto(input.map { LottoNumber(it.toInt()) })
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getWinningLotto()
    }
}