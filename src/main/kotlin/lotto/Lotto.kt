package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == DEFAULT_LOTTO_SIZE)
    }

    fun checkLottoNumberException(): List<Int> {
//중복숫자 체크 및 6자리 확인
        if (numbers.size != 6)  throw IllegalArgumentException(ERROR_INPUT_NUMBER_LENGTH)
        if (numbers.distinct().size != 6) throw IllegalArgumentException(ERROR_INPUT_NUMBER_DISTINCT)
        return numbers.sorted()
    }
   private fun isAllNumbersInRange(list: List<Int>): Boolean {
        for (number in list) {
            if (number < 1 || number > 45) {
                return false
            }
        }
        return true
    }


    companion object {
        private const val DEFAULT_LOTTO_SIZE = 6
        private const val ERROR_INPUT_NUMBER_LENGTH = "[ERROR] 6개의 숫자만 입력 가능합니다"
        private const val ERROR_INPUT_NUMBER_DISTINCT = "수 중에 중복이 있습니다."
    }
}
