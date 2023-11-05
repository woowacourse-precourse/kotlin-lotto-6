package lotto.domain

import lotto.utils.Constants
import lotto.validate.ValidateSplit
import lotto.view.InputView.inputMyNumbers
import lotto.view.OutputView.showInputMyNumbersMessage

class WinningLotto {
    init {
        showInputMyNumbersMessage()
    }

    fun createWinningLotto(): List<Int> {
        val winningNumbers = splitMyNumbers(inputMyNumbers())
        return changeStringToInteger(winningNumbers)
    }

    private fun splitMyNumbers(myNumbers: String): List<String> {
        val validateSplit = ValidateSplit()
        return validateSplit.validateSplitMyNumbers(myNumbers.split(Constants.DELIMITER))
    }

    private fun changeStringToInteger(numbers: List<String>) : List<Int> {
        return numbers.map { it.toInt() }
    }
}