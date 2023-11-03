package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(setOf(numbers).size == numbers.size)
    }
}
