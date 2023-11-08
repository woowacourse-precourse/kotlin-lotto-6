package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size==6)
    }

    fun getNumbers(): List<Int> {
        return numbers.sorted()
    }
}