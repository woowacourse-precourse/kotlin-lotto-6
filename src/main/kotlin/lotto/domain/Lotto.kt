package lotto.domain

import lotto.utils.Constants

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Constants.LOTTO_NUMBER_SIZE) { Constants.ERROR_LOTTO_NUMBER_SIZE }
        require(numbers.all { it in Constants.MIN_NUMBER..Constants.MAX_NUMBER }) { Constants.ERROR_LOTTO_NUMBER_RANGE }
        require(numbers.distinct().size == numbers.size) { Constants.ERROR_LOTTO_NUMBER_DUPLICATE }
    }

    fun matchCount(prizeLottoNumber: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val lottoNumberCount = numbers.count { it in prizeLottoNumber }
        val bonusNumberMatchStatus = numbers.any { it == bonusNumber }
        return Pair(lottoNumberCount, bonusNumberMatchStatus)
    }
}
