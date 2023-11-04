package lotto

import camp.nextstep.edu.missionutils.*

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun getLottoNumberString() : String {
        return numbers.sorted().toString()
    }

    fun getRank(winningNumbers: List<Int>, bonusNumber : Int) : Int {
        var matchNumbers = getMatchNumbers(winningNumbers)
        return when(matchNumbers){
            3 -> 5
            4 -> 4
            6 -> 1
            5 -> {
                if(numbers.contains(bonusNumber)) 2
                else 3
            }
            else -> 0
        }
    }

    fun getMatchNumbers(winningNumbers: List<Int>) : Int {
        var matchNumbers = 0
        winningNumbers.forEach {
            if(numbers.contains(it)) matchNumbers++
        }
        return matchNumbers
    }
}
