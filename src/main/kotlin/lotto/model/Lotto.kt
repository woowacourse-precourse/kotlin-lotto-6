package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }
    fun getLotto(): List<Int> {
        return numbers.sorted()
    }
}

object LottoFactory {
    fun createLotto(numbers: List<Int>): Lotto {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        return Lotto(numbers)
    }
}