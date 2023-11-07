package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputMoney(): Int {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine().toInt()
    }

    fun inputWinningNumber(): List<Int> {
        println(INPUT_WINNING_NUMBER)
        return Console.readLine().split(SPLIT_STRING).map { number ->
            number.toInt()
        }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER)
        return Console.readLine().toInt()
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
        private const val INPUT_WINNING_NUMBER = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
        private const val SPLIT_STRING = ","
    }
}