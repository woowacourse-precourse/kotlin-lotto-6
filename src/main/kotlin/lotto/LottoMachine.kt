package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN
import lotto.LottoConstants.LOTTO_NUMBER_SIZE

object LottoMachine : LottoGenerator {

    override fun generate(): Lotto {
        val numbers =
            Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE) ?: emptyList()
        return Lotto(numbers.sorted())
    }
}
