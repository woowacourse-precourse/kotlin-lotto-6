package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

object Reader {
    private fun readLine() = Console.readLine()
    fun readLottoMoney(): Long {
        return InputChecker.checkInputMoney(readLine())
    }

    fun readLottoNumbers(): Lotto {
        return InputChecker.checkInputNumbers(readLine())
    }

    fun readLottoBonus(lotto: Lotto): Int {
        return InputChecker.checkInputBonus(lotto, readLine())
    }
}