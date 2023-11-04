package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == numbers.size)
    }

    fun amount(): List<Int> {
        return numbers.sorted()
    }
}
