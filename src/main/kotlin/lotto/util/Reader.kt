package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

object Reader {
    private fun readLine() = Console.readLine()
    private const val RETURN_CODE = 0L
    private val RETURN_LOTTO = Lotto(listOf(0, 0, 0, 0, 0, 0))
    fun readLottoMoney(): Long {
        var money = RETURN_CODE
        while (money == RETURN_CODE) {
            money = InputChecker.checkInputMoney(readLine(), RETURN_CODE)
        }

        return money
    }

    fun readLottoNumbers(): Lotto {
        var lotto = RETURN_LOTTO
        while (lotto == RETURN_LOTTO) {
            lotto = InputChecker.checkInputNumbers(readLine(), RETURN_LOTTO)
        }

        return lotto
    }

    fun readLottoBonus(lotto: Lotto): Int {
        var bonus = RETURN_CODE.toInt()
        while (bonus == RETURN_CODE.toInt()) {
            bonus = InputChecker.checkInputBonus(lotto, readLine(), RETURN_CODE.toInt())
        }
        return bonus
    }
}