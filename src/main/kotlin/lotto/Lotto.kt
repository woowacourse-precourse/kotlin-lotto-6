package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.toSet().size == 6)
    }

    override fun toString(): String {
        return numbers.toString()
    }
}
