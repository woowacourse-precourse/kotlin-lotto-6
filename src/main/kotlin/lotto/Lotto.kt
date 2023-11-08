package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun contains(number: Int): Boolean {
        return numbers.contains(number)
    }

    val lotteryNumber get() = this.numbers
}
