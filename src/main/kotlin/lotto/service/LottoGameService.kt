package lotto.service

import lotto.domain.*
import lotto.repository.RandomNumberLottoesRepository
import lotto.util.RandomLottoNumbersGenerator

class LottoGameService(
    private val randomLottoNumbersGenerator: RandomLottoNumbersGenerator,
    private val randomLottoNumberRepository: RandomNumberLottoesRepository
) {

    fun generateRandomNumbers(purchaseAmount: Int): Lottoes {
        val randomNumbersLottoes = mutableListOf<Lotto>()
        repeat(purchaseAmount) {
            randomNumbersLottoes.add(Lotto(randomLottoNumbersGenerator.generate()))
        }
        randomLottoNumberRepository.saveRandomNumbers(randomNumbersLottoes.toList())
        return randomLottoNumberRepository.loadRandomNumbers()
    }

    fun calculateLottoResult(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): LottoGameResult {
        val randomLottoes = randomLottoNumberRepository.loadRandomNumbers()
        return randomLottoes.calculateGameResult(winningNumbers, bonusNumber)
    }
}