package lotto

import lotto.Constants.COUNT
import lotto.Constants.COUNT_ERROR
import lotto.Constants.DUPLICATE_ERROR
import lotto.Constants.FIFTH_PLACE
import lotto.Constants.FIRST_PLACE
import lotto.Constants.FOURTH_PLACE
import lotto.Constants.NOTHING
import lotto.Constants.SECOND_PLACE
import lotto.Constants.THIRD_PLACE

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == COUNT) { COUNT_ERROR }
        require(numbers.toSet().size == COUNT) { DUPLICATE_ERROR }
    }


    fun isWin(winNum: List<Int>, bonusNum: Int): Int {
        when (winNum.intersect(numbers).size) {
            3 -> return FIFTH_PLACE
            4 -> return FOURTH_PLACE
            5 -> {
                if (numbers.contains(bonusNum)) return SECOND_PLACE
                return THIRD_PLACE
            }

            6 -> return FIRST_PLACE
        }
        return NOTHING
    }
}
