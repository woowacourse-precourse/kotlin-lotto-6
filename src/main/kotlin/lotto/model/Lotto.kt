package lotto.model

import lotto.constants.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Exception.SIZE }
        require(numbers.size == numbers.distinct().size) { Exception.DUPLICATION }
        require(numbers == numbers.sorted()) { Exception.SORT }
        require(numbers.all { number -> number in 1..45 })
    }

    override fun toString() = numbers.toString()
}
