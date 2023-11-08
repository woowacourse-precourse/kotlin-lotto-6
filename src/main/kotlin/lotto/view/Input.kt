package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun buyLotto(): Int = Console.readLine().toInt()

    fun drawWinNumber(): MutableList<Int> {
        val winNum: MutableList<String> = Console.readLine().split(",").toMutableList()
        val winNumber = winNum.map { it.toInt() }
        return winNumber.toMutableList()
    }
}