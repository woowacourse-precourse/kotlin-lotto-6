package lotto.service

import lotto.domain.*
import lotto.repository.RandomNumberLottosRepository
import lotto.util.RandomLottoNumbersGenerator

class LottoGameService(
    private val randomLottoNumbersGenerator: RandomLottoNumbersGenerator,
    private val randomLottoNumberRepository: RandomNumberLottosRepository
) {

    fun generateRandomNumbers(purchaseAmount: Int): Lottos {
        val randomNumbersLottos = mutableListOf<Lotto>()
        repeat(purchaseAmount) {
            randomNumbersLottos.add(Lotto(randomLottoNumbersGenerator.generate()))
        }
        randomLottoNumberRepository.saveRandomNumbers(randomNumbersLottos.toList())
        return randomLottoNumberRepository.loadRandomNumbers()
    }

    fun calculateLottoResult(winningNumbers: WinningNumbers, bonusNumber: BonusNumber): LottoGameResult {
        val randomLottos = randomLottoNumberRepository.loadRandomNumbers()
        return randomLottos.calculateGameResult(winningNumbers, bonusNumber)
    }
}