package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.UserInputException
import java.lang.IllegalArgumentException

class InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            val purchaseAmount = Console.readLine()
            try {
                return UserInputException.purchaseAmountException(purchaseAmount) ?: continue
            }catch (e: IllegalArgumentException){
                println(e.message)
            }

        }

    }

    fun inputPrizeLottoNumber(): List<Int> {
        val prizeLottoNumber = Console.readLine()
        val prizeLottoNumberList = prizeLottoNumber.split(SEPARATOR)
        return prizeLottoNumberList.map { it.toInt() }
    }

    fun inputPrizeBonusNumber(): Int {
        val bonusNumber = Console.readLine()
        return bonusNumber.toInt()
    }

    companion object {
        private const val SEPARATOR = ","
    }
}