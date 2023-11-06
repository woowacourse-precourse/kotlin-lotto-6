package lotto.repository

import lotto.domain.Lotto
import lotto.domain.Lottos

class RandomNumberLottosRepository {
    private lateinit var randomNumbers: Lottos

    fun saveRandomNumbers(randomNumbers: List<Lotto>) {
        this.randomNumbers = Lottos(randomNumbers)
    }

    fun loadRandomNumbers(): Lottos = randomNumbers
}