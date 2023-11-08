package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.model.*
import lotto.model.isAmountInThousand
import lotto.model.isDigit
import lotto.model.isLessThanThousand
import lotto.model.isLottoNumber

class InputView {
    fun inputPurchaseAmount(): Int {
        val amount = Console.readLine()
        amount.isDigit()
        amount.isLessThanThousand()
        amount.isAmountInThousand()
        return amount.toInt()
    }

    fun inputWinNumber(): List<Int> {
        val winNumber = Console.readLine().trim().split(",")
        winNumber.checkLottoSize()
        winNumber.forEach { number ->
            number.isDigit()
            number.isLottoNumber()
        }
        winNumber.isDuplicateNumber()
        return winNumber.map { it.toInt() }
    }

    fun inputBonusNumber(winNumber: List<Int>): Int {
        val bonusNumber = Console.readLine()
        bonusNumber.isDigit()
        bonusNumber.isLottoNumber()
        bonusNumber.hasNoDuplicateNumbers(winNumber)
        return bonusNumber.toInt()
    }
}