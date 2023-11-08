package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.size == numbers.toSet().size)
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
}
