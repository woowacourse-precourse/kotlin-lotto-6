package lotto.util

import camp.nextstep.edu.missionutils.Console

object Reader {
    private fun readLine() = Console.readLine()
    private const val RETURN_CODE = 0
    private val RETURN_LIST = listOf(0)

    fun readLottoMoney(): Int {
        var money = RETURN_CODE
        while (money == RETURN_CODE) {
            money = InputChecker.checkInputMoney(readLine(), RETURN_CODE)
            println()
        }

        return money
    }

    fun readLottoNumbers(): List<Int> {
        var lottoNumbers = RETURN_LIST
        while (lottoNumbers == RETURN_LIST) {
            lottoNumbers = InputChecker.checkInputNumbers(readLine(), RETURN_LIST)
            println()
        }

        return lottoNumbers
    }

    fun readLottoBonus(lottoNumbers: List<Int>): Int {
        var bonus = RETURN_CODE
        while (bonus == RETURN_CODE) {
            bonus = InputChecker.checkInputBonus(lottoNumbers, readLine(), RETURN_CODE)
            println()
        }

        return bonus
    }
}