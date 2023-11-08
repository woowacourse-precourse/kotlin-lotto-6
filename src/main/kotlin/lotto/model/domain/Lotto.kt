package lotto.model.domain

import lotto.util.Validator.validateIsUnique
import lotto.util.Validator.validateRange

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { INVALID_LOTTO_SIZE }
        validateIsUnique(numbers)
        validateNumbersRange(numbers)
    }

    private fun validateNumbersRange(numbers: List<Int>) {
        numbers.forEach { number -> validateRange(number) }
    }

    fun getCountOfMatch(newLotto: Lotto): Int {
        return TOTAL_NUMBER_OF_LOTTO_COUNT - (newLotto.toAscendingNumbers() + numbers).toSet().size
    }

    fun isContainNumber(number: Int): Boolean = numbers.contains(number)

    fun toAscendingNumbers(): List<Int> = numbers.sorted()

    override fun toString(): String {
        return toAscendingNumbers().toString()
    }

    companion object {
        const val TOTAL_NUMBER_OF_LOTTO_COUNT = 12
        const val INVALID_LOTTO_SIZE = "6개의 숫자를 입력해 주세요"
    }
}