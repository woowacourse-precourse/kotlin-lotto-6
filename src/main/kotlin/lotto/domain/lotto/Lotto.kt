package lotto.domain.lotto

import lotto.util.Error

class Lotto(private val numbers: List<Int>) : Comparable<Lotto> {

    init {
        require(numbers.size == 6) { Error.InvalidLottoNumberCount.message }
        require(numbers.size == numbers.toSet().size) { Error.HasDuplicateLottoNumber.message }
        numbers.forEach { number -> require(number in 1..45) { Error.InvalidLottoNumber.message } }
    }

    fun isDuplicated(bonusNumber: Int) = numbers.contains(bonusNumber)

    fun hasNumber(number: Int): Boolean = numbers.contains(number)

    override fun compareTo(other: Lotto): Int {
        var count = 0
        numbers.forEach { number ->
            if (other.hasNumber(number))
                count++
        }
        return count
    }

    override fun toString(): String {
        return numbers.sorted().toString() + '\n'
    }
}
