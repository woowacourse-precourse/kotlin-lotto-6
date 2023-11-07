package lotto.util

import camp.nextstep.edu.missionutils.Console

object Reader {
    private fun readLine() = Console.readLine()
    private const val RETURN_CODE = 0L
    private val RETURN_LIST = listOf(0)
    fun readLottoMoney(): Long {
        var money = RETURN_CODE
        while (money == RETURN_CODE) {
            money = InputChecker.checkInputMoney(readLine(), RETURN_CODE)
        }

        return money
    }

    fun readLottoNumbers(): List<Int> {
        var lottoNumbers = RETURN_LIST
        while (lottoNumbers == RETURN_LIST) {
            lottoNumbers = InputChecker.checkInputNumbers(readLine(), RETURN_LIST)
        }

        return lottoNumbers
    }

    fun readLottoBonus(lottoNumbers: List<Int>): Int {
        var bonus = RETURN_CODE.toInt()
        while (bonus == RETURN_CODE.toInt()) {
            bonus = InputChecker.checkInputBonus(lottoNumbers, readLine(), RETURN_CODE.toInt())
        }
        return bonus
    }
}