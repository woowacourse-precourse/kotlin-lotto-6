package lotto.domain

import lotto.Input
import net.bytebuddy.pool.TypePool.Resolution.Illegal

object WinningNumber {

    init {
        println("")
        println("당첨 번호를 입력해 주세요.")
    }

    fun getWinningNumbers(): MutableList<Int> {
        //list<String>
        val winningNumbers = Input.inputWinningNumber()
        val winningIntNumbers = changeStringToIntNumber(winningNumbers)
        checkValidationWinningNumber(winningIntNumbers)
        return winningIntNumbers
    }

    private fun changeStringToIntNumber(winningNumbers: List<String>): MutableList<Int> {
        val winningIntNumbers = mutableListOf<Int>()
        for(number in winningNumbers) {
            winningIntNumbers.add(number.toInt())
        }
        return winningIntNumbers
    }

    private fun checkValidationWinningNumber(winningNumbers: List<Int>) {
        checkLengthWinningNumber(winningNumbers)
        checkDuplicateWinningNumber(winningNumbers)
        checkRangeWinningNumber(winningNumbers)
    }

    private fun checkLengthWinningNumber(winningNumbers: List<Int>) {
        if(winningNumbers.size != 6)
            throw IllegalArgumentException("오류")
    }

    private fun checkDuplicateWinningNumber(winningNumbers: List<Int>) {
        if(winningNumbers.distinct().size != winningNumbers.size)
            throw IllegalArgumentException("오류")
    }

    private fun checkRangeWinningNumber(winningNumbers: List<Int>) {
        for(number in winningNumbers) {
            val winningNumber = number.toInt()
            if(winningNumber in 1..45)
                continue
            throw IllegalArgumentException("오류")
        }
    }
}