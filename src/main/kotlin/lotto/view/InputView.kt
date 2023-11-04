package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.util.Exception

class InputView {

    fun inputPrice(): Int {
        val price = Console.readLine()
        Exception.validateInputPrice(price)
        return price.toInt()
    }

    fun inputLuckyNumber(): List<Int> {
        var luckyNumbers = ""
        luckyNumbers = Console.readLine()
        Exception.validateInputLuckyNumber(luckyNumbers)
        return luckyNumbers.split(",").map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        var bonusNumber = ""
        bonusNumber = Console.readLine()
        Exception.validateInputBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }
}