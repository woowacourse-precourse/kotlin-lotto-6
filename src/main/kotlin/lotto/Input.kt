package lotto

import camp.nextstep.edu.missionutils.Console

class Input {
    fun inputMoney(): Int {
        println(INPUT_PURCHASE_AMOUNT)
        return Console.readLine().toInt()
    }

    companion object {
        private const val INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요."
    }
}