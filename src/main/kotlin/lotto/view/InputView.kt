package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.utils.UserInputException
import kotlin.IllegalArgumentException

class InputView {
    fun inputPurchaseAmount(): Int {
        while (true) {
            val purchaseAmount = Console.readLine()
            try {
                return UserInputException.purchaseAmountException(purchaseAmount)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputPrizeLottoNumber(): List<Int> {
        while (true) {
            val prizeLottoNumber = Console.readLine()
            try {
                return UserInputException.lottoException(prizeLottoNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    fun inputPrizeBonusNumber(): Int {
        while (true) {
            val bonusNumber = Console.readLine()
            try {
                return UserInputException.bonusNumberException(bonusNumber)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}