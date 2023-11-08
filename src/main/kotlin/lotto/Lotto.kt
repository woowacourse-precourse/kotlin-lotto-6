package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    fun isSameAs(other: Lotto): Boolean {
        return numbers.toSet() == other.numbers.toSet()
    }
}
