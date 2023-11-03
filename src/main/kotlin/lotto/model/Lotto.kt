package lotto.model

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    fun serve():List<Int>{
        return numbers
    }
}
