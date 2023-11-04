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
        return amount.toInt() / 1000
    }

    fun inputWinNumber() {
        val winNumber = Console.readLine().trim().split(",")
        winNumber.checkLottoSize()
        winNumber.forEach { number ->
            number.isLottoNumber()
        }
        winNumber.isDuplicateNumber()
    }
}