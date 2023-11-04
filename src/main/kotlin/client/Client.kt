package client

import camp.nextstep.edu.missionutils.Console
import constants.INPUT_BONUS_NUMBER_MESSAGE
import constants.INPUT_BYE_MONEY_MESSAGE
import constants.INPUT_WIN_NUMBER_MESSAGE
import constants.OUTPUT_BYE_NUMBER_MESSAGE
import lotto.Lotto

class Client {
    private val util = ClientUtil()
    fun inputBuyMoneyToCount(): Int {
        println(INPUT_BYE_MONEY_MESSAGE)
        val input = Console.readLine()
        util.checkIsInteger(input)
        val money = input.toInt()
        util.checkNoDividedByThousand(money)
        return money / 1000
    }

    fun inputWinNumberList(): List<Int> {
        println(INPUT_WIN_NUMBER_MESSAGE)
        val input = Console.readLine()
        util.checkIsCorrectWinNumber(input)
        return winNumberToList(input)
    }

    private fun winNumberToList(input: String): List<Int> {
        val stringInputList = input.split(",")
        stringInputList.forEach {
            util.checkIsCorrectLottoNumber(it.toInt())
        }
        return input.split(",").map { it.toInt() }
    }

    fun outputUsersLotto(lottoList: MutableList<Lotto>) {
        println(lottoList.size.toString() + OUTPUT_BYE_NUMBER_MESSAGE)
        lottoList.forEach { lotto ->
            println(lotto.toString())
        }
    }

    fun inputBonusNumber(): Int {
        println(INPUT_BONUS_NUMBER_MESSAGE)
        val input = Console.readLine()
        util.checkIsInteger(input)
        util.checkIsCorrectLottoNumber(input.toInt())
        return input.toInt()
    }
}