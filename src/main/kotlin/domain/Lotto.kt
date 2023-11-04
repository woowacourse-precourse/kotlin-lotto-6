package domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size != 6)
    }
    fun getNumbers() = numbers
}
