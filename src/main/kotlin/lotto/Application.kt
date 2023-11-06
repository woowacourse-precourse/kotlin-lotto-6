package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView
import lotto.validator.InputValidator

fun main() {
    val lottos = generateLottos()
    OutputView.outputLottos(lottos)

    val winningLotto = getWinningLotto()
    val bonusNumber = getBonusNumber()
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

private fun getBonusNumber(): LottoNumber {
    return try {
        val input = InputView.inputBonusNumber()
        InputValidator.validateInputBonusNumber(input)
        LottoNumber(input.toInt())
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getBonusNumber()
    }
}