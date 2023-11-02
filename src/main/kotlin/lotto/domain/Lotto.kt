package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getNumberPerLotto(): List<Int> {
        return numbers
    }
    // TODO: 추가 기능 구현
}
