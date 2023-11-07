package lotto

import lotto.domain.*
import lotto.domain.lotto.*
import lotto.view.InputView
import lotto.view.OutputView
import lotto.validator.InputValidator

fun main() {
    val purchasedLottos = purchaseLottos()
    OutputView.outputLottos(purchasedLottos)

    val winningLotto = getWinningLotto()
    val winningResult = LottoShop.getWinningResult(winningLotto, purchasedLottos)
    OutputView.outputWinningResult(winningResult)
}

private fun purchaseLottos(): Lottos {
    return try {
        val money = getPurchaseAmount()
        LottoShop.purchaseLottos(money)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        purchaseLottos()
    }
}

private fun getPurchaseAmount(): Money {
    return try {
        val input = InputView.inputPurchaseAmount()
        InputValidator.validateInputPurchaseAmount(input)
        Money(input.toInt())
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getPurchaseAmount()
    }
}

private fun getWinningLotto(): WinningLotto {
    return try {
        val winningNumbers = getWinningNumbers()
        val bonusNumber = getBonusNumber()
        WinningLotto(winningNumbers, bonusNumber)
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getWinningLotto()
    }
}

private fun getWinningNumbers(): Lotto {
    return try {
        val input = InputView.inputWinningNumbers()
        InputValidator.validateInputWinningNumbers(input)
        Lotto(input.map { LottoNumber(it.toInt()) })
    } catch (e: IllegalArgumentException) {
        println(e.message)
        getWinningNumbers()
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