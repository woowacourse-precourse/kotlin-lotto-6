package lotto

import camp.nextstep.edu.missionutils.Console

class User {

    fun inputLottoNumber(): List<Int> {
        val inputString = Console.readLine()
        return inputString.split(",").map { it.toInt() }
    }

    fun inputBonusNum(): Int {
        return Console.readLine().toInt()
    }

    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }
}
