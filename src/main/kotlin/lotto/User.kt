package lotto

import camp.nextstep.edu.missionutils.Console

class User {
    private var _amount: Int = 0
    val amount get() = _amount

    fun inputAmount() {
        val input = Console.readLine()

        _amount = input.toInt()
    }
}