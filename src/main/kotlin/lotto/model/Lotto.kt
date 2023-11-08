package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(hasNumberDuplicates())
    }

    fun printNumbers() {
        println(numbers.sorted())
    }

    fun getNumbers() = numbers

    private fun hasNumberDuplicates(): Boolean = numbers.toSet().size == numbers.size


}
