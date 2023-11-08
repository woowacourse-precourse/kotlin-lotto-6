package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == NUMBERS_PER_TICKET) { "[ERROR] 로또 번호는 6개입니다."}
    }

    override fun toString(): String = numbers.toString()

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun countDuplicateNumbers(other: Lotto): Int {
        val intersection = numbers.intersect(other.numbers)
        return intersection.size
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBERS_PER_TICKET = 6
        const val PRICE_PER_TICKET = 1000
    }
}
