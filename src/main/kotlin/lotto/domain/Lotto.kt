package lotto.domain

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == LOTTO_NUMBER_COUNT)
        require(numbers.toSet().size == LOTTO_NUMBER_COUNT)
    }

    companion object{
        val LOTTO_NUMBER_COUNT = 6
    }
}
