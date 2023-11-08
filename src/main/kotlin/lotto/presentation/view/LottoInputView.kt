package lotto.presentation.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.enum.error.Error
import lotto.domain.enum.number.UnitNumber

class LottoInputView {

    fun getPrice(): Int {
        val input = Console.readLine()
        require(input.toIntOrNull() != null) { println(Error.NUMBER_FORMAT_ERROR.message) }
        require(input.toInt() % UnitNumber.LOTTO_PRICE.number == SHARE_ZERO) { println(Error.PRICE_UNIT.message) }
        return input.toInt()
    }

    fun getWinningNumbers(): List<Int> {
        val input = Console.readLine()
        val winningNumbers = input.split(",").map { number ->
            requireNotNull(number.toIntOrNull()) { println(Error.INPUT_FORM.message) }
        }
        require(winningNumbers.size == UnitNumber.LOTTO_COUNT.number) { println(Error.INPUT_FORM.message) }
        return winningNumbers
    }

    fun getBonusNumber(): Int {
        val input = Console.readLine()
        return requireNotNull(input.toIntOrNull())
    }

    companion object {
        const val SHARE_ZERO = 0
    }

}