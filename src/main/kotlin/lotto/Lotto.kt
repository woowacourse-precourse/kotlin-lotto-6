package lotto

import lotto.Rank

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
        if (numbers.size != numbers.toSet().size) {
            throw IllegalArgumentException("[ERROR] 로또번호가 중복되었습니다.")
        }
    }

    fun compareNumber(finalNum: List<Int>, bonusNum: Int): Int {
        val numbersSet = numbers.toSet()
        val FinalNumSet = finalNum.toSet()
        val compareSet = numbersSet + FinalNumSet
        
        when (compareSet.size) {
            9 -> return Rank.FIFTH.ordinal
            8 -> return Rank.FOURTH.ordinal
            7 -> return bonusCompare(numbers, bonusNum)
            6 -> return Rank.FIRST.ordinal
            else -> return Rank.BOOM.ordinal
        }
    }

    fun bonusCompare(numbers: List<Int>, bonusNum: Int): Int {
        if (numbers.contains(bonusNum)) {
            return Rank.SECOND.ordinal
        } else {
            return Rank.THIRD.ordinal
        }
        
    }

    fun getNum(): List<Int> {
        return numbers;
    }
}
