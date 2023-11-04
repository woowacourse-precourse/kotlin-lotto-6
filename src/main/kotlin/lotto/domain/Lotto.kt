package lotto.domain

import lotto.constants.isDuplicateErrorMessage

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        isDuplicate()
    }
    fun sortNumbers(): List<Int> {
        return numbers.sorted()
    }

   fun isDuplicate(){
        if(numbers.distinct().size!=6){
            throw IllegalArgumentException(isDuplicateErrorMessage)
        }
    }

}
