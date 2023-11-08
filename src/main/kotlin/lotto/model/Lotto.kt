package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    fun getLotto():List<Int>{
        return numbers.sorted()
    }
}
