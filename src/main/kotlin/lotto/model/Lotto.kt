package lotto.model

import lotto.utils.Values

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == Values.LOTTERY_NUMBER_AMOUNT)
        require(numbers.distinct().size == Values.LOTTERY_NUMBER_AMOUNT)
        for(item in numbers){
            require(Values.MINIMUM_LOTTERY_NUMBER <= item && item <= Values.MAXIMUM_LOTTERY_NUMBER)
        }
    }
    fun getNumbers(): List<Int> {
        return numbers
    }
}
