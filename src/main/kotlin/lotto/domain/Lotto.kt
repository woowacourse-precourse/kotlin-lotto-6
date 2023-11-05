package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun contains(number: Int): Boolean = numbers.contains(number)

    fun getNumbers(): List<Int> = numbers

    override fun toString(): String {
        return numbers.sorted().toString()
    }
    // TODO: 추가 기능 구현
}
