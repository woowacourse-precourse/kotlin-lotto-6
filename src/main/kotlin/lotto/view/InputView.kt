package lotto.view

import lotto.INPUT_MESSAGE_BONUS_NUMBER
import lotto.INPUT_MESSAGE_COST
import lotto.INPUT_MESSAGE_LOTTO_NUMBERS

class InputView {
    fun inputCost(): Int {
        println(INPUT_MESSAGE_COST)

        return readLine()!!.toInt()
    }

    fun inputLottoNumbers(): String {
        println(INPUT_MESSAGE_LOTTO_NUMBERS)
        return readLine()!!
    }

    fun inputBonusNumber(): Int {
        println(INPUT_MESSAGE_BONUS_NUMBER)
        return readLine()!!.toInt()
    }
}