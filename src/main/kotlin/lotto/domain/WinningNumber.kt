package lotto.domain

import lotto.Input
import lotto.constant.Exception
import lotto.constant.Constant
import lotto.constant.OutputMessage

object WinningNumber {

    private var winningIntNumbers = mutableListOf<Int>()

    init {
        println(OutputMessage.MESSAGE_INPUT_WINNING_NUMBER)
    }

    fun getWinningNumbers(): MutableList<Int> {
        return winningIntNumbers
    }

    fun inputWinningNumbers() {
        //list<String>
        val winningNumbers = Input.inputWinningNumber()
        val winningIntNumbersBeforeCheck = changeStringToIntNumber(winningNumbers)
        checkValidationWinningNumber(winningIntNumbersBeforeCheck)
        winningIntNumbers = winningIntNumbersBeforeCheck
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
        if(winningNumbers.size != Constant.INPUT_COUNT)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_LENGTH_WINNING_NUMBER)
    }

    private fun checkDuplicateWinningNumber(winningNumbers: List<Int>) {
        if(winningNumbers.distinct().size != winningNumbers.size)
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_DUPLICATE)
    }

    private fun checkRangeWinningNumber(winningNumbers: List<Int>) {
        for(winningNumber in winningNumbers) {
            if(winningNumber in Constant.MIN_LOTTO_NUMBER..Constant.MAX_LOTTO_NUMBER)
                continue
            throw IllegalArgumentException(Exception.MESSAGE_EXCEPT_RANGE)
        }
    }
}