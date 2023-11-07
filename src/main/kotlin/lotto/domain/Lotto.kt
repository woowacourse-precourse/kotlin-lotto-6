package lotto.domain

import lotto.util.Error

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Error.InvalidLottoNumberCount.message }
        numbers.forEach { number -> require(number in 1..45) { Error.InvalidLottoNumber.message } }
    }

    override fun toString(): String {
        return numbers.sorted().toString() + '\n'
    }
}
