package lotto

import lotto.domain.*
import lotto.view.InputView
import lotto.view.OutputView
import lotto.validator.InputValidator

fun main() {
    val purchasedLottos = purchaseLottos()
    OutputView.outputLottos(purchasedLottos)

    val winningLotto = getWinningLotto()
    val bonusNumber = getBonusNumber()
}

private fun purchaseLottos(): Lottos {
    return try {
        val money = getInputPurchaseAmount()
        LottoShop.purchaseLottos(money)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        purchaseLottos()
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