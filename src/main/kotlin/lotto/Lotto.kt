package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(isValidNumberCount()) { INVALID_NUMBER_COUNT_ERROR_MESSAGE }
    }

    private fun isValidNumberCount() = numbers.size == NUMBER_COUNT

    companion object {
        const val NUMBER_COUNT = 6
        const val INVALID_NUMBER_COUNT_ERROR_MESSAGE = "로또 번호의 개수가 6개가 아닙니다."
    }
}
