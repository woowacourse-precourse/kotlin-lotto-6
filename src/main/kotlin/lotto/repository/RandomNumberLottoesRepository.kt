package lotto.repository

import lotto.domain.Lotto
import lotto.domain.Lottoes

class RandomNumberLottoesRepository {
    private lateinit var randomNumbers: Lottoes

    fun saveRandomNumbers(randomNumbers: List<Lotto>) {
        this.randomNumbers = Lottoes(randomNumbers)
    }

    fun loadRandomNumbers(): Lottoes = randomNumbers
}