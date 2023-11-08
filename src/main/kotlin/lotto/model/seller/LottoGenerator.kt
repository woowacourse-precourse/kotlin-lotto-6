package lotto.model.seller

import lotto.model.Lotto
import lotto.model.Payment
import lotto.model.random.DefaultRandomGenerator
import lotto.model.random.RandomGenerator
import lotto.model.toLottoNumbers

class LottoGenerator private constructor(private val generator: RandomGenerator) {

    fun createLottos(payment: Payment): Ticket {
        val lottos = mutableListOf<Lotto>()
        repeat(payment.purchase) {
            val randomNumbers = generator.pickUniqueNumberInRange(START_NUMBER, END_NUMBER, LOTTO_NUMBER_COUNT)
            lottos.add(Lotto(randomNumbers.toLottoNumbers()))
        }
        return Ticket(lottos = lottos, cost = payment.cost)
    }

    companion object {
        private const val START_NUMBER = 1
        private const val END_NUMBER = 45
        private const val LOTTO_NUMBER_COUNT = 6

        fun createWithRandomGenerator(generator: RandomGenerator = DefaultRandomGenerator()): LottoGenerator =
            LottoGenerator(generator)
    }
}