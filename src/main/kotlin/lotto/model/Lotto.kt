package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
        for (i in numbers) {
            require(i > 0 && i < 46)
        }
    }

    fun getLotto(): List<Int> {
        return numbers.sorted()
    }
}

object LottoFactory {
    fun createLotto(numbers: List<Int>): Lotto {
        return Lotto(numbers)
    }
}