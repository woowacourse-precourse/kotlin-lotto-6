package client

import camp.nextstep.edu.missionutils.Console
import constants.*
import lotto.Lotto
import lotto.WinState
import java.text.DecimalFormat

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

    fun outputWinPrize(winPrizeList: List<WinState>) {
        println(OUTPUT_THREE_WIN_MESSAGE+ winPrizeList.count { it == WinState.THREE }+OUTPUT_COUNT)
        println(OUTPUT_FOUR_WIN_MESSAGE+ winPrizeList.count { it == WinState.FOUR }+OUTPUT_COUNT)
        println(OUTPUT_FIVE_WIN_MESSAGE+ winPrizeList.count { it == WinState.FIVE }+OUTPUT_COUNT)
        println(OUTPUT_FIVE_WITH_BONUS_WIN_MESSAGE+ winPrizeList.count { it == WinState.FIVEPLUSBONUS }+OUTPUT_COUNT)
        println(OUTPUT_SIX_WIN_MESSAGE+ winPrizeList.count { it == WinState.SIX }+OUTPUT_COUNT)
    }
    fun formatNumber(number: Float): String {
        val decimalFormat = DecimalFormat("#,###.#")
        return decimalFormat.format(number)
    }
    fun outputRateOfReturn(rateOfReturn: Float) {
        println(OUTPUT_RATE_OF_RETURN_FIRST_MESSAGE+formatNumber(rateOfReturn)+OUTPUT_RATE_OF_RETURN_SECOND_MESSAGE)
    }
}