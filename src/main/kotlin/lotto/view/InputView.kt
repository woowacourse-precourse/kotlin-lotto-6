package lotto.view

import lotto.constants.Constants
import camp.nextstep.edu.missionutils.Console
import lotto.domain.ValidateLottoAmount
import lotto.domain.ValidateLottoNumbers

class InputView {
    fun inputBuyAmount(): Int {
        println(Constants.INPUT_BUY_AMOUNT)
        return ValidateLottoAmount().buyAmount(Console.readLine())
    }

    fun inputWinningNumbers() : List<Int> {
        println(Constants.INPUT_WINNING_NUMBER)
        return ValidateLottoNumbers().validateWinningNumbers(Console.readLine())
    }

    fun inputBonusNumber() {
        println(Constants.INPUT_BONUS_NUMBER)
        val bonusNumber = Console.readLine()
    }
}