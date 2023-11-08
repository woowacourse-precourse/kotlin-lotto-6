package lotto.controller

import lotto.Lotto
import lotto.Referee
import lotto.calculator.LottoResultCalculator
import lotto.error.ErrorHandler
import lotto.error.InputErrorHandler
import lotto.generator.NumbersGenerator
import lotto.generator.RandomNumbersGenerator
import lotto.model.LottoResult
import lotto.validator.string.BonusNumberValidator
import lotto.validator.string.PurchaseAmountValidator
import lotto.validator.string.StringValidator
import lotto.validator.string.WinningNumbersValidator
import lotto.view.*

class LottoGameController(
    private val errorHandler: ErrorHandler = InputErrorHandler(),
    private val numberGenerator: NumbersGenerator = RandomNumbersGenerator(),
    private val purchaseAmountValidator: StringValidator = PurchaseAmountValidator(),
    private val winningNumbersValidator: StringValidator = WinningNumbersValidator(),
) {
    private val purchaseAmountInputView = PurchaseAmountInputView()
    private val winningNumberInputView = WinningNumberInputView()
    private val bonusNumberInputView = BonusNumberInputView()
    private val lottoView = LottoView()
    private val lottoResultView = LottoResultView()
    private lateinit var bonusNumberValidator: StringValidator
    private lateinit var referee: Referee
    private val lottoPrizeCalculator = LottoResultCalculator()

    fun showPurchaseAmountInputView() {
        errorHandler.handle(
            action = {
                purchaseAmountInputView.input()
                purchaseAmountValidator.validate(purchaseAmountInputView.price)
            },
            callback = { showPurchaseAmountInputView() }
        )
    }

    fun showLottoView() {
        val count = purchaseAmountInputView.price.toLottoCount()
        val lottos = List(count) { Lotto(numberGenerator.generate()) }
        lottoView.update(lottos)
    }

    fun showWinnerNumberInputView() {
        errorHandler.handle(
            action = {
                winningNumberInputView.input()
                winningNumbersValidator.validate(winningNumberInputView.winningNumber)
            },
            callback = { showWinnerNumberInputView() }
        )
    }

    fun showBonusNumberInputView() {
        errorHandler.handle(
            action = {
                bonusNumberInputView.input()
                bonusNumberValidator = BonusNumberValidator(
                    winningNumberInputView.winningNumber.toNumbers()
                )
                bonusNumberValidator.validate(bonusNumberInputView.bonusNumber)
            },
            callback = { showBonusNumberInputView() }
        )
    }

    fun showLottoResultView() {
        referee = Referee(
            winningNumberInputView.winningNumber.toLotto(),
            bonusNumberInputView.bonusNumber.toInt()
        )
        val ranks = referee.determineRank(lottoView.lottos)
        val lottoResult: LottoResult =
            lottoPrizeCalculator.calculate(purchaseAmountInputView.price.toInt(), ranks)
        lottoResultView.update(lottoResult)
    }

    private fun String.toLottoCount() = toInt() / LOTTO_PRICE_UNIT
    private fun String.toNumbers() = split(",").map { it.trim().toInt() }

    private fun String.toLotto() = Lotto(toNumbers())

    companion object {
        private const val LOTTO_PRICE_UNIT = 1000
    }
}