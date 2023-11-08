package lotto.data.repository

import lotto.data.datasource.RandomNumberDataSource
import lotto.domain.model.Lotto
import lotto.domain.repository.LottoRepository

class LottoRepositoryImpl(
    private val randomNumberDataSource: RandomNumberDataSource
) : LottoRepository {
    override fun getLottoes(amount: Int): List<Lotto> {
        val lottoes = mutableListOf<Lotto>()
        repeat(amount) {
            val numbers = randomNumberDataSource.pickUniqueNumbersInRange(
                Lotto.MIN_NUMBER,
                Lotto.MAX_NUMBER,
                Lotto.NUMBER_OF_LOTTO_NUMBERS
            ).sortedBy { it }

            lottoes.add(Lotto(numbers = numbers))
        }

        return lottoes
    }
}