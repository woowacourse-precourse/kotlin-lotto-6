package lotto.util

import camp.nextstep.edu.missionutils.Console
import lotto.model.Lotto

class Reader {

    // Todo: 입력 메서드 수정
    fun readLottoPrice(): Int {
        val readPrice = Console.readLine()
        return 0
    }
    // Todo: 입력 메서드 수정
    fun readLottoNumber(): Lotto {
        val readNumberList = Console.readLine()
        return Lotto(listOf(0, 0, 0, 0, 0, 0))
    }
}