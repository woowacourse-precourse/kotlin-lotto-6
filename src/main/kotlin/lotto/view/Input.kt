package lotto.view

import camp.nextstep.edu.missionutils.Console

class Input {
    fun buyLotto(): Int {
        val amount = Console.readLine().toInt()
        return amount
    }

    fun drawWinNumber(): MutableList<Int> {
        val winNum = Console.readLine().split(",").toMutableList()
        val winNumber = winNum.map { it.toInt() }
        return winNumber.toMutableList()
    }

    fun drawBonusNumber(): Int = Console.readLine().toInt()
}
