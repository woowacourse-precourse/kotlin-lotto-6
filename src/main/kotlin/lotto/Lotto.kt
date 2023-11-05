package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(hasNumberDuplicates())
    }
    private fun hasNumberDuplicates() : Boolean = numbers.toSet().size == numbers.size
}
