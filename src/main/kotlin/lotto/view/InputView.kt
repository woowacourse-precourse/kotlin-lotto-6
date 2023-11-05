package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun inputMoney(): Int {
        return Console.readLine().toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        return Console.readLine().split(",").map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        return Console.readLine().toInt()
    }
}