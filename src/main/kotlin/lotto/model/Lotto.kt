package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    // TODO: 추가 기능 구현
    override fun toString(): String = numbers.joinToString(separator = ", ", prefix = "[", postfix = "]")
    fun toSet(): Set<Int> = numbers.toSet()
}