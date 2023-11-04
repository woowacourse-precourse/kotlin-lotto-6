package lotto.domain

import camp.nextstep.edu.missionutils.Randoms

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }
    fun sortNumbers(): List<Int> {
        return numbers
    }

    fun printNumbers(): String {
        return ""
    }

    fun isDuplicate(){

    }

}
