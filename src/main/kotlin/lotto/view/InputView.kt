package lotto.view

import camp.nextstep.edu.missionutils.Console

class InputView {
    fun inputBuyPrice(): Int {
        return Console.readLine().toInt()
    }

    fun inputMyNumbers(): String {
        return Console.readLine()
    }
}