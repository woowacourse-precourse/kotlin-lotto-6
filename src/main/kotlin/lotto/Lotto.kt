package lotto

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { "$ERROR $LOTTO_NUMBER_ONLY_SIX_DIGITS" }
        require(checkDuplicateNumbers()) { "$ERROR $LOTTO_NUMBER_CANNOT_DUPLICATED" }
    }

    private fun checkDuplicateNumbers(): Boolean {
        return numbers.distinct().size == numbers.size
    }

    companion object {
        const val ERROR = "[ERROR]"
        const val LOTTO_NUMBER_ONLY_SIX_DIGITS = "로또 번호는 6자리여야 합니다."
        const val LOTTO_NUMBER_CANNOT_DUPLICATED = "로또 번호는 중복될 수 없습니다."
    }

}
