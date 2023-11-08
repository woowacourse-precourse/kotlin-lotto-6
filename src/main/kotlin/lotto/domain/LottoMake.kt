package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.LOTTO_NUMBER_COUNT
import lotto.util.LOTTO_NUMBER_MAX
import lotto.util.LOTTO_NUMBER_MIN

class LottoMake() {
    fun resultLottoNumber(purchaseCount: Int): MutableList<Lotto> {
        val lotto: MutableList<Lotto> = mutableListOf()
        for (count in 0 until purchaseCount) {
            val numbers = makeLottoNumber()
            println(numbers)
            lotto.add(numbers)
        }
        return lotto
    }

    private fun makeLottoNumber(): Lotto {
        val number =
            Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT)
                .sorted()
        return Lotto(number)
    }
}