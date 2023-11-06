package lotto.model

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6){
            Constants.ERROR_LOTTO_SIZE
        }
        require(numbers.size == numbers.toSet().size){
            Constants.ERROR_LOTTO_DUPlICATION
        }
    }

    fun rangeValidate() {
        for (number in numbers){
            if (number > 45 || number < 1){
                println(Constants.ERROR_LOTTO_RANGE)
                throw IllegalArgumentException(Constants.ERROR_LOTTO_RANGE)
            }
        }
    }



    fun serve(): List<Int> {
        return numbers
    }
}
