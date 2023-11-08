package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == DEFAULT_LOTTO_SIZE)
        checkLottoNumberException()
    }

    fun checkLottoNumberException(): List<Int> {
        if (numbers.size != 6) throw IllegalArgumentException(ERROR_INPUT_NUMBER_LENGTH)
        if (numbers.distinct().size != 6) throw IllegalArgumentException(ERROR_INPUT_NUMBER_DISTINCT)
        isAllNumbersInRange(numbers)
        return numbers.sorted()
    }

    private fun isAllNumbersInRange(list: List<Int>): Boolean {
        for (number in list) {
            if (number < 1 || number > 45) {
                throw IllegalArgumentException(ERROR_INPUT_NUMBER_RANGE)
            }
        }
        return true
    }


    companion object {
        private const val DEFAULT_LOTTO_SIZE = 6
        private const val ERROR_INPUT_NUMBER_LENGTH = "[ERROR] 6개의 숫자만 입력 가능합니다"
        private const val ERROR_INPUT_NUMBER_DISTINCT = "1[ERROR]수 중에 중복이 있습니다."
        private const val ERROR_INPUT_NUMBER_RANGE = "[ERROR]1~45사이의 수가 아닙니다"
    }
}
