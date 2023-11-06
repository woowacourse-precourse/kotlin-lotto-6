package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "$ERROR $LOTTO_NUMBER_ONLY_SIX_DIGITS" }
        require(checkDuplicateNumbers()) { "$ERROR $LOTTO_NUMBER_CANNOT_DUPLICATED" }
        require(numbersOutOfRange()) { "$ERROR $LOTTO_NUMBER_RANGE" }
    }

    private fun checkDuplicateNumbers(): Boolean {
        return numbers.distinct().size == numbers.size
    }

    private fun numbersOutOfRange(): Boolean {
        return numbers.all { it in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER }
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val LOTTO_NUMBER_ONLY_SIX_DIGITS = "로또 번호는 6자리여야 합니다."
        const val LOTTO_NUMBER_CANNOT_DUPLICATED = "로또 번호는 중복될 수 없습니다."
        const val LOTTO_NUMBER_RANGE = "로또 번호는 1부터 45사이의 숫자여야 합니다."
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }

}
