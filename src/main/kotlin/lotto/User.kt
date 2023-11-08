package lotto

import camp.nextstep.edu.missionutils.Console

private const val COMMA = ","

class User {

    fun inputBonusNum(): Int {
        return Console.readLine().toInt()
    }

    fun inputMoney(): String {
        return Console.readLine()
    }

    fun inputLottoNumber(): List<Int> {
        val inputString = Console.readLine()
        return inputString.split(COMMA).map { it.toInt() }
    }
}
