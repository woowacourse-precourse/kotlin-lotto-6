package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

object Reader {
    private fun readLine() = Console.readLine()
    fun readLottoMoney(): Long {
        return InputChecker.checkInputMoney(readLine())
    }

    // Todo: 입력 메서드 수정
    fun readLottoNumber(): Lotto {
        readLine()
        return Lotto(listOf(0, 0, 0, 0, 0, 0))
    }
}