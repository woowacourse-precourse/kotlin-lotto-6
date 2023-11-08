package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == 6)
    }

    override fun toString(): String = numbers.toString()

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun countDuplicateNumbers(other: Lotto): Int {
        val intersection = numbers.intersect(other.numbers)
        return intersection.size
    }
}
