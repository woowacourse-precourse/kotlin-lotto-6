package lotto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        return "$numbers"
    }

    fun getNumbers(): List<Int> {
        return numbers
    }

    // TODO: 추가 기능 구현
}
