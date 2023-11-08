package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.model.LottoWinningNumbers
import lotto.utils.validator.LottoCostInputValidator
import lotto.utils.validator.LottoWinningNumberInputValidator

class LottoInputHandler {
    private var lottoCostInputValidator: LottoCostInputValidator
    private var lottoWinningNumberInputValidator: LottoWinningNumberInputValidator

    init {
        lottoCostInputValidator = LottoCostInputValidator()
        lottoWinningNumberInputValidator = LottoWinningNumberInputValidator()
    }

    fun receiveLottoCost(): Int {
        val cost = Console.readLine()
        try {
            lottoCostInputValidator.validate(cost)
        } catch (e: IllegalArgumentException) {
            return receiveLottoCost()
        }
        return cost.toInt()
    }

    fun receiveLottoWinningNumbers(): List<Int> {
        val numbers = Console.readLine()
            .split(",")
        try {
            lottoWinningNumberInputValidator.validate(numbers)
        } catch (e: IllegalArgumentException) {
            return receiveLottoWinningNumbers()
        }
        return numbers.map { it.toInt() }
    }

    fun receiveLottoBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine()
        try {
            lottoWinningNumberInputValidator.validate(winningNumbers, bonusNumber)
        } catch (e: IllegalArgumentException) {
            return receiveLottoBonusNumber(winningNumbers)
        }
        return bonusNumber.toInt()
    }

}