package client

import camp.nextstep.edu.missionutils.Console
import constants.*
import lotto.Lotto
import lotto.WinState
import java.text.DecimalFormat

class Client {
    private val util = ClientUtil()
    fun inputBuyMoneyToCount(): Int {
        return try {
            println(INPUT_BYE_MONEY_MESSAGE)
            val input = Console.readLine()
            util.checkIsInteger(input)
            val money = input.toInt()
            util.checkNoDividedByThousand(money)
            money / 1000
        } catch (e: IllegalArgumentException) {
            inputBuyMoneyToCount()
        }

    }

    fun inputWinNumberList(): List<Int> {
        return try {
            println(INPUT_WIN_NUMBER_MESSAGE)
            val input = Console.readLine()
            util.checkIsCorrectWinNumber(input)
            winNumberToList(input)
        } catch (e: IllegalArgumentException) {
            inputWinNumberList()
        }
    }

    private fun winNumberToList(input: String): List<Int> {
        return try {
            val stringInputList = input.split(",")
            util.checkIsDuplicated(stringInputList)
            stringInputList.forEach {
                util.checkIsCorrectLottoNumber(it.toInt())
            }
            input.split(",").map { it.toInt() }
        } catch (e: IllegalArgumentException) {
            inputWinNumberList()
        }

    }

    fun outputUsersLotto(lottoList: MutableList<Lotto>) {
        println(lottoList.size.toString() + OUTPUT_BYE_NUMBER_MESSAGE)
        lottoList.forEach { lotto ->
            println(lotto.toString())
        }
    }

    fun inputBonusNumber(winNumberList: List<Int>): Int {
        return try {
            println(INPUT_BONUS_NUMBER_MESSAGE)
            val input = Console.readLine()
            util.checkIsInteger(input)
            util.checkIsCorrectLottoNumber(input.toInt())
            util.checkIsInWinNumberList(input.toInt(), winNumberList)
            input.toInt()
        } catch (e: IllegalArgumentException) {
            inputBonusNumber(winNumberList)
        }

    }

    fun outputWinPrize(winPrizeList: List<WinState>) {
        println(OUTPUT_THREE_WIN_MESSAGE + winPrizeList.count { it == WinState.THREE } + OUTPUT_COUNT)
        println(OUTPUT_FOUR_WIN_MESSAGE + winPrizeList.count { it == WinState.FOUR } + OUTPUT_COUNT)
        println(OUTPUT_FIVE_WIN_MESSAGE + winPrizeList.count { it == WinState.FIVE } + OUTPUT_COUNT)
        println(OUTPUT_FIVE_WITH_BONUS_WIN_MESSAGE + winPrizeList.count { it == WinState.FIVEPLUSBONUS } + OUTPUT_COUNT)
        println(OUTPUT_SIX_WIN_MESSAGE + winPrizeList.count { it == WinState.SIX } + OUTPUT_COUNT)
    }

    fun formatNumber(number: Float): String {
        val decimalFormat = DecimalFormat("#,###.#")
        return decimalFormat.format(number)
    }

    fun outputRateOfReturn(rateOfReturn: Float) {
        println(OUTPUT_RATE_OF_RETURN_FIRST_MESSAGE + formatNumber(rateOfReturn) + OUTPUT_RATE_OF_RETURN_SECOND_MESSAGE)
    }
}