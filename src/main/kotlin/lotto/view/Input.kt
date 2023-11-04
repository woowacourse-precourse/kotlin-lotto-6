package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.constants.askBonusNumberMessage
import lotto.constants.askPurchaseAmountMessage
import lotto.constants.askWinningLottoNumberMessage
import lotto.constants.indivisibleBy1000ErrorMessage
import lotto.constants.isBlankErrorMessage
import lotto.constants.isNotIntErrorMessage
import lotto.constants.isNotSize6ErrorMessage


class Input {

    fun askPurchaseAmount(): Int {
        println(askPurchaseAmountMessage)
        return validatePurchaseAmount(Console.readLine())
    }

    fun askWinningLottoNumber(): List<Int> {
        println(askWinningLottoNumberMessage)
        return validateWinningLottoNumber(Console.readLine())
    }

    fun askBonusNumber(): Int {
        println(askBonusNumberMessage)
        return validateBonusNumber(Console.readLine())
    }

    fun validatePurchaseAmount(input: String): Int {
        val purchaseAmount:Int = toInt(input)
        if (purchaseAmount % 1000 != 0) {
            throw IllegalArgumentException(indivisibleBy1000ErrorMessage)
        }
        return purchaseAmount/1000
    }

    fun validateWinningLottoNumber(input: String): List<Int> {
        val winningLottoNumber = input.split(",").map {
            toInt(it)
        }
        if(winningLottoNumber.size!=6){
            throw IllegalArgumentException(isNotSize6ErrorMessage)
        }
        return winningLottoNumber
    }

    fun validateBonusNumber(input: String): Int {
        val bonusNumber = toInt(input)
        if (input.toInt() % 1000 != 0) {
            throw IllegalArgumentException(indivisibleBy1000ErrorMessage)
        }
        return bonusNumber
    }

    private fun toInt(input:String):Int{
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(isNotIntErrorMessage)
        } else if (input.isBlank()) {
            throw IllegalArgumentException(isBlankErrorMessage)
        }
        return input.toInt()
    }
}