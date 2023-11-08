package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == 6) { "[ERROR] 로또 번호는 6개입니다."}
    }

    override fun toString(): String = numbers.toString()

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun countDuplicateNumbers(other: Lotto): Int {
        val intersection = numbers.intersect(other.numbers)
        return intersection.size
    }
}
