package lotto.lotto

import lotto.lotto.winning.WinningNumber
import lotto.lotto.winning.WinningStrategyEnum
import lotto.consts.GameConst

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == GameConst.NUM_COUNT)
        require(numbers.distinct().size == numbers.size)
        require(numbers.all {
            it in 1..GameConst.MAX_NUM
        })
    }

    fun checkWinning(winningNumber: WinningNumber, checker: WinningStrategyEnum) : Boolean{
        return checker.calculate(numbers, winningNumber)
    }

    override fun toString(): String {
        val sorted = numbers.sorted()
        val stringBuilder = StringBuilder()
        stringBuilder.append("[")
        sorted.forEachIndexed{ index, value ->
            stringBuilder.append(value)
            if(index != sorted.size - 1){
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]")
        return stringBuilder.toString()
    }
}
