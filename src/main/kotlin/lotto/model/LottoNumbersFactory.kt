package lotto.model

import lotto.util.randomNumberGenerator

class LottoNumbersFactory {
    fun createLottoNumbers(): Lotto {
        var createdLottoNumbers = randomNumberGenerator(LOTTO_START_NUM, LOTTO_LAST_NUM, LOTTO_NUM_COUNT)
        return Lotto(createdLottoNumbers)
    }

    companion object {
        const val LOTTO_NUM_COUNT = 6
        const val LOTTO_START_NUM = 1
        const val LOTTO_LAST_NUM = 45
    }
}