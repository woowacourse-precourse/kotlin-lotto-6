package lotto.model

import lotto.util.LottoValidatorUtil

class Lotto(private val numbers: List<Int>) {

    init {
        LottoValidatorUtil.checkWinningNumberSize(numbers)
        checkLottoNumbersInRange()
    }

    override fun toString(): String {
        return getNumbers().toString()
    }

    fun getNumbers() = numbers

    private fun checkLottoNumbersInRange() {
        numbers.forEach { _number ->
            LottoValidatorUtil.checkNumberInRange(_number)
        }
    }
}
