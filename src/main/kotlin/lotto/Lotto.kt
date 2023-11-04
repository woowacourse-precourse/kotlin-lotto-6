package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(isValidNumberCount()) { INVALID_NUMBER_COUNT_ERROR_MESSAGE }
        require(isValidRangeNumbers()) { INVALID_RANGE_NUMBER }
    }

    private fun isValidNumberCount() = numbers.size == NUMBER_COUNT

    private fun isValidRangeNumbers() = numbers.all { it in MIN_NUMBER..MAX_NUMBER }

    companion object {
        const val NUMBER_COUNT = 6
        const val INVALID_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호의 개수가 ${NUMBER_COUNT}개가 아닙니다."

        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val INVALID_RANGE_NUMBER = "로또 번호의 범위가 ${MIN_NUMBER}이상 ${MAX_NUMBER}이하가 아닙니다."
    }
}
