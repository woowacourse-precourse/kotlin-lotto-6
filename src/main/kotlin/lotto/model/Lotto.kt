package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
    }

    fun validate() {
        if (numbers.toSet().size != numbers.size)
            throw IllegalStateException(Constants.ERROR_LOTTO_DUPlICATION)
    }

    fun serve(): List<Int> {
        return numbers
    }
}
