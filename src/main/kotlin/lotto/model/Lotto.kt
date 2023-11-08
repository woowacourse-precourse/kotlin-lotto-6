package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getNUmber() : List<Int> {
        return numbers
    }
}
