package lotto.view

import camp.nextstep.edu.missionutils.Console
class InputView {
    fun inputAmount(): Int {
        val line: String = Console.readLine()
        try {
            val amount: Int = line.toInt()
            if (amount % 1000 != 0)
                throw IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나눌수 있는 숫자여야 합니다.")
            return (amount / 1000)
        } catch (e: Exception) {
            throw IllegalArgumentException("[ERROR] 구입 금액은 1000으로 나눌수 있는 숫자여야 합니다.")
        }
    }

}