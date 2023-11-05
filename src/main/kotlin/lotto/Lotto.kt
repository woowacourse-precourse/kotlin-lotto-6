package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(hasDuplicates())
    }
    private fun hasDuplicates() : Boolean = numbers.toSet().size == numbers.size
}
