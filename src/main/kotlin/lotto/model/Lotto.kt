package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
    }

    fun duplicationValidate() {
        if (numbers.toSet().size != numbers.size){
            println(Constants.ERROR_LOTTO_DUPlICATION)
            throw IllegalStateException(Constants.ERROR_LOTTO_DUPlICATION)
        }
    }

    fun rangeValidate() {
        for (number in numbers){
            if (number > 45 || number < 1){
                println(Constants.ERROR_LOTTO_RANGE)
                throw IllegalStateException(Constants.ERROR_LOTTO_RANGE)
            }
        }
    }
    fun sizeValidate() {
        if (numbers.size != Constants.SIX){
            println(Constants.ERROR_LOTTO_SIZE)
            throw IllegalStateException(Constants.ERROR_LOTTO_SIZE)
        }
    }


    fun serve(): List<Int> {
        return numbers
    }
}
