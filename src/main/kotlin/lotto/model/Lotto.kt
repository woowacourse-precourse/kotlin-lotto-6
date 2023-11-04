package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return getNumbers().toString()
    }

    fun getNumbers() = numbers
}
