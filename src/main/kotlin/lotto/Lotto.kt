package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(isValidNumberCount()) { INVALID_NUMBER_COUNT_ERROR_MESSAGE }
        require(isValidRangeNumber()) { INVALID_NUMBER_RANGE_ERROR_MESSAGE }
        require(isValidDistinctNumber()) { INVALID_DISTINCT_NUMBER_ERROR_MESSAGE }
    }

    fun getSortedNumbers() = numbers.sorted() // 도메인 로직 X

    private fun isValidNumberCount() = numbers.size == NUMBER_COUNT

    private fun isValidRangeNumber() = numbers.all { it in MIN_NUMBER..MAX_NUMBER }

    private fun isValidDistinctNumber() = numbers.size == numbers.distinct().size

    companion object {
        const val NUMBER_COUNT = 6
        const val INVALID_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호의 개수는 ${NUMBER_COUNT}개이어야 합니다."

        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val INVALID_NUMBER_RANGE_ERROR_MESSAGE = "${MIN_NUMBER}이상 ${MAX_NUMBER}이하의 범위를 벗어난 로또 번호가 있습니다."

        const val INVALID_DISTINCT_NUMBER_ERROR_MESSAGE = "중복된 로또 번호가 있습니다."
    }
}
