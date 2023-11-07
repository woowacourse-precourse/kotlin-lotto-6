package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants

object InputView {
    private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    private const val INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요."
    private const val INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    fun inputPurchaseAmount(): Int {
        println(INPUT_PURCHASE_AMOUNT)
        return readLine()!!.toInt()
    }

    fun inputWinningNumber(): List<Int> {
        print(Constants.SPACING)
        println(INPUT_WINNING_NUMBER)
        return readLine()!!.split(Constants.COMMA).map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        print(Constants.SPACING)
        println(INPUT_BONUS_NUMBER)
        return readLine()!!.toInt()
    }

    private fun readLine(): String? {
        return Console.readLine()
    }
}
