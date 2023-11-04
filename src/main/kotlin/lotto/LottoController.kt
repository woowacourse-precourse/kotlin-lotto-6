package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.Lottos
import lotto.LottoResult

class LottoController {
    fun pickRandomNums(): MutableList<Int>? {
        val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return numbers
    }

    fun pickRandomNum(): Int {
        val number = Randoms.pickNumberInRange(1, 45)
        return number
    }
}