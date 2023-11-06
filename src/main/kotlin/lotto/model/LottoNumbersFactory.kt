package lotto.model

import lotto.util.randomNumberGenerator

class LottoNumbersFactory {
    companion object {
        const val LOTTO_NUM_COUNT = 6
        const val LOTTO_START_NUM = 1
        const val LOTTO_LAST_NUM = 45
    }

    fun createLottoNumbers():Lotto {
        var createdLottoNumbers = mutableSetOf<Int>()
        while (createdLottoNumbers.size != LOTTO_NUM_COUNT){
            var randomNum = randomNumberGenerator(LOTTO_START_NUM, LOTTO_LAST_NUM)
            createdLottoNumbers.add(randomNum)
        }
        return Lotto(createdLottoNumbers.toList())
    }
}