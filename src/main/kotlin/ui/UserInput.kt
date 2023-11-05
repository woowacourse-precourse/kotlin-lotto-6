package ui

import camp.nextstep.edu.missionutils.Console

const val MSG_INPUT_MONEY = "구입금액을 입력해 주세요."
object UserInput {

    fun readMoney(): Int {
        println(MSG_INPUT_MONEY)
        val money = Console.readLine()
        return money.toInt()
    }
}
