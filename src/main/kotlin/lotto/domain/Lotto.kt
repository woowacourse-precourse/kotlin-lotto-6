package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoNumbers(): List<Int> {
        return numbers
    }
}
