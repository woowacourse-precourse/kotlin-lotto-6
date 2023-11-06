package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
    }

    fun duplicationValidate() {
        if (numbers.toSet().size != numbers.size)
            throw IllegalStateException(Constants.ERROR_LOTTO_DUPlICATION)
    }

    fun rangeValidate() {
        for (number in numbers){
            if (number > 45 || number < 1){
                throw IllegalStateException(Constants.ERROR_LOTTO_RANGE)
            }
        }
    }

    fun serve(): List<Int> {
        return numbers
    }
}
