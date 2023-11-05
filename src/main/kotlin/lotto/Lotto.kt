package lotto

import exception.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6){Exception.EXCEPTION_INVALID_SIZE}
        require(numbers.all { it in 1..45 }){Exception.EXCEPTION_INVALID_NUMBER}
        require(numbers.distinct().size == 6){Exception.EXCEPTION_DUPLICATE_NUMBER}
    }

    fun getNumbers(): List<Int> {
        return numbers
    }
}
