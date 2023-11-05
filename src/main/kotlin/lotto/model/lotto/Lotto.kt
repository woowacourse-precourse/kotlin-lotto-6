package lotto.model.lotto

import lotto.constants.Exception

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { Exception.LOTTO_SIZE }
        require(numbers.size == numbers.distinct().size) { Exception.LOTTO_DUPLICATION }
        require(numbers == numbers.sorted()) { Exception.LOTTO_SORT }
        require(numbers.all { number -> number in 1..45 }) { Exception.LOTTO_RANGE }
    }

    fun countMatchingNumber(otherLotto: Lotto) =
        otherLotto.numbers.filter { otherNumber ->
            this.numbers.contains(otherNumber)
        }.size

    fun isMatchingBonus(bonus: Bonus) = numbers.contains(bonus.number)

    override fun toString() = numbers.toString()
}
