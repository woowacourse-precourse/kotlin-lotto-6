package lotto.models

class Lotto(private val numbers: List<Int>) {

    init {
        require(isValidNumberCount()) { NUMBER_COUNT_ERROR_MESSAGE }
        require(isValidNumberRange()) { NUMBER_RANGE_ERROR_MESSAGE }
        require(isValidDistinctNumber()) { DISTINCT_NUMBER_ERROR_MESSAGE }
    }

    fun getNumbers() = numbers.sorted()

    private fun isValidNumberCount() = numbers.size == NUMBER_COUNT

    private fun isValidNumberRange() = numbers.all { it in MIN_NUMBER..MAX_NUMBER }

    private fun isValidDistinctNumber() = numbers.size == numbers.distinct().size

    companion object {
        const val NUMBER_COUNT = 6
        const val NUMBER_COUNT_ERROR_MESSAGE = "로또 번호의 개수는 ${NUMBER_COUNT}개이어야 합니다."

        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBER_RANGE_ERROR_MESSAGE = "로또 번호는 ${MIN_NUMBER}에서 ${MAX_NUMBER}사이어야 합니다."

        const val DISTINCT_NUMBER_ERROR_MESSAGE = "중복된 로또 번호가 있습니다."
    }
}
