package lotto


class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.isSizeOfSix()) { LENGTH_ERROR }
        require(numbers.isNotDuplicated()) { DUPLICATED_ERROR }
        require(numbers.isInRange()) { RANGE_ERROR }
        require(numbers.isAscending()) { SORT_ERROR }
    }

    fun contains(number: Int) = numbers.contains(number)

    fun countMatch(otherLotto: Lotto): Int {
        val matchCount = numbers.fold(0) { total, number ->
            if (otherLotto.contains(number)) return@fold total + 1
            total
        }
        return matchCount
    }

    private fun List<Int>.isSizeOfSix() = (size == LOTTO_NUMBER_SIZE)

    private fun List<Int>.isNotDuplicated() = (distinct().size == size)

    private fun List<Int>.isInRange() = all { it in RANGE }

    private fun List<Int>.isAscending() = (this == this.sorted())

    override fun toString() = numbers.toString()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Lotto) return false
        return numbers == other.numbers
    }

    override fun hashCode(): Int {
        return numbers.hashCode()
    }

    companion object {
        private const val MIN_LENGTH = 1
        private const val MAX_LENGTH = 45
        private const val LOTTO_NUMBER_SIZE = 6
        private val RANGE = MIN_LENGTH..MAX_LENGTH
        const val LENGTH_ERROR = "로또 번호는 6개여야 합니다"
        const val DUPLICATED_ERROR = "로또 번호는 중복되면 안됩니다"
        const val RANGE_ERROR = "로또 번호는 1 ~ 45 사이여야 합니다"
        const val SORT_ERROR = "로또 번호는 오름차순이여야 합니다"
    }
}