package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.isNotEmpty()) {throw IllegalArgumentException(NUMBER_IS_EMPTY)}
        require(numbers.size == LOTTO_NUM_CNT) {throw IllegalArgumentException(WRONG_SIZE)}
        require(numbers.all { it in MIN_NUM..MAX_NUM }) {throw IllegalArgumentException(OUT_OF_RANGE)}
        require(isNotDuplicated(numbers)) {throw IllegalArgumentException(IS_DUPLICATED)}
    }

    fun getNumbers() : List<Int> {
        return this.numbers
    }

    private fun isNotDuplicated(numbers: List<Int>) : Boolean = numbers.distinct().size == this.numbers.size

    companion object {
        const val MIN_NUM = 1
        const val MAX_NUM = 45
        const val LOTTO_NUM_CNT = 6
        const val NUMBER_IS_EMPTY = "입력되지 않은 숫자가 있습니다."
        const val WRONG_SIZE = "${LOTTO_NUM_CNT}개의 숫자를 입력해야 합니다."
        const val OUT_OF_RANGE = "로또 숫자는 $MIN_NUM ~ $MAX_NUM 사이의 숫자를 입력해야 합니다."
        const val IS_DUPLICATED = "중복된 숫자를 입력해서는 안 됩니다."
    }
}
