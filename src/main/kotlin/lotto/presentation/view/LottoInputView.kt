package lotto.presentation.view

import camp.nextstep.edu.missionutils.Console
import lotto.domain.enum.error.NumberError
import lotto.domain.enum.error.PriceNumberError
import lotto.domain.enum.error.WinningNumberError
import lotto.domain.enum.number.UnitNumber

class LottoInputView {

    fun getPrice(): Int {
        val input = Console.readLine()
        val price = requireNotNull(input.toIntOrNull()) { println(NumberError.NOT_NUMBER.message) }
        require(price % UnitNumber.LOTTO_PRICE.number == SHARE_ZERO) { println(PriceNumberError.UNIT.message) }
        return price
    }

    fun getWinningNumbers(): List<Int> {
        val input = Console.readLine()
        val winningNumbers = input.split(",").map { number ->
            requireNotNull(number.toIntOrNull()) { println(WinningNumberError.INPUT_FORM.message) }
        }
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