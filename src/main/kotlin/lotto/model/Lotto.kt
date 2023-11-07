package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    override fun toString(): String {
        val nums = numbers.joinToString(", ")
        return "[$nums]"
    }

    // TODO: 추가 기능 구현
}
