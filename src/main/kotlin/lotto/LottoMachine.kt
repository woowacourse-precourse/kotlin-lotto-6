package lotto

import camp.nextstep.edu.missionutils.Randoms
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN
import lotto.LottoConstants.LOTTO_NUMBER_SIZE
import lotto.LottoConstants.LOTTO_PRICE

object LottoMachine : LottoGenerator {
    private const val MINIMUM_MONEY = 1

    fun buyTickets(money: Int): List<Lotto> =
        (MINIMUM_MONEY..money / LOTTO_PRICE).map { generate() }

    override fun generate(): Lotto {
        val numbers =
            Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_SIZE) ?: emptyList()
        return Lotto(numbers.sorted())
    }
}
