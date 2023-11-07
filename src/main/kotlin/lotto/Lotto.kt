package lotto

import lotto.Rank
// val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)

// 제공된 Lotto 클래스를 활용해 구현해야 한다.
// numbers의 접근 제어자인 private을 변경할 수 없다.
// Lotto에 필드를 추가할 수 없다.
// Lotto의 패키지 변경은 가능하다.


class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6)
    }

    fun compareNumber(finalNum: List<Int>, bonusNum: Int): Int {
        val numbersSet = numbers.toSet()
        val FinalNumSet = finalNum.toSet()
        val compareSet = numbersSet + FinalNumSet
        
        when (compareSet.size) {
            9 -> return Rank.FIFTH.ordinal
            8 -> return Rank.FOURTH.ordinal
            7 -> bonusCompare(numbers, bonusNum)
            6 -> return Rank.FIRST.ordinal
            else -> return Rank.BOOM.ordinal
        }
        return Rank.BOOM.ordinal
    }

    fun bonusCompare(numbers: List<Int>, bonusNum: Int): Int {
        if (numbers.contains(bonusNum)) {
            return Rank.SECOND.ordinal
        } else {
            return Rank.THIRD.ordinal
        }
        
    }
}
