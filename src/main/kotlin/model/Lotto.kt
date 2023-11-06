package model

import util.LottoValidation

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidation.REQUIRED_LOTTO_NUMBER_COUNT.isValid(numbers)
        LottoValidation.UNIQUE_LOTTO_NUMBERS.isValid(numbers)
        LottoValidation.LOTTO_NUMBER_RANGE.isValid(numbers)
    }

    // TODO: 추가 기능 구현

    fun getLottoNumberInfo() = numbers.sorted()

    fun getLottoRank(winningNumber: List<Int>, bonusNumber: Int): Int {
        when (winningNumber.count { numbers.contains(it) }) {
            3 -> return 5
            4 -> return 4
            5 -> {
                if (numbers.contains(bonusNumber)) return 2
                return 3
            }

            6 -> return 1
        }
        return 0
    }
}
