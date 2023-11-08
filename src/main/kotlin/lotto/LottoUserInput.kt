package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.LottoUtil.isAllInLottoRange
import lotto.LottoUtil.isAllNumbers
import lotto.LottoUtil.isInLottoRange
import lotto.LottoUtil.toIntList
import lotto.LottoUtil.uniqueSize
import lotto.enums.BonusNumberInput
import lotto.enums.AmountInputType
import lotto.enums.WinningNumbersInput
import lotto.messages.ErrorMessage
import lotto.messages.InputMessage

object LottoUserInput {

    fun getPurchaseAmountInput(): Int {
        while (true) {
            printPurchaseAmountMessage()
            val input = Console.readLine()
            when (checkAmountInput(input)) {
                AmountInputType.NOT_INTEGER -> printAmountFormatErrorMessage()
                AmountInputType.NOT_POSITIVE -> printAmountIsNotPositiveMessage()
                AmountInputType.NOT_MULTIPLE_OF_1000 -> printAmountIsNotMultipleOf1000Message()
                AmountInputType.VALID -> return input.toInt()
            }
        }
    }

    fun checkAmountInput(input: String): AmountInputType {
        return when {
            !LottoUtil.isStringNumber(input) -> AmountInputType.NOT_INTEGER
            input.toInt() <= 0 -> AmountInputType.NOT_POSITIVE
            !LottoUtil.isMultipleOf1000(input.toInt()) -> AmountInputType.NOT_MULTIPLE_OF_1000
            else -> AmountInputType.VALID
        }
    }

    private fun printPurchaseAmountMessage() {
        println(InputMessage.PURCHASE_AMOUNT)
    }

    private fun printAmountFormatErrorMessage() {
        LottoUtil.printErrorMessage(ErrorMessage.AMOUNT_WRONG_INPUT_FORMAT)
    }

    private fun printAmountIsNotMultipleOf1000Message() {
        LottoUtil.printErrorMessage(ErrorMessage.AMOUNT_NOT_MULTIPLE_OF_1000)
    }

    private fun printAmountIsNotPositiveMessage() {
        LottoUtil.printErrorMessage(ErrorMessage.AMOUNT_NOT_POSITIVE_VALUE)
    }

    fun getWinningNumbers(): List<Int> {
        while (true) {
            printWinningNumbersMessage()
            val input = Console.readLine()
            when (checkWinningNumbersInput(input)) {
                WinningNumbersInput.NOT_ALL_NUMBERS -> printWinningNumberContainsNonNumbers()
                WinningNumbersInput.NUMBERS_COUNT_WRONG -> printWinningNumbersWrongSize()
                WinningNumbersInput.OUT_OF_LOTTO_RANGE -> printWinningNumbersOutOfRange()
                WinningNumbersInput.VALID -> return inputToWinningNumbers(input)
            }
        }
    }

    private fun printWinningNumbersMessage() {
        println(InputMessage.WINNING_NUMBER)
    }

    fun checkWinningNumbersInput(input: String): WinningNumbersInput {
        val tokens = input.split(",")
        return when {
            !tokens.isAllNumbers() -> WinningNumbersInput.NOT_ALL_NUMBERS
            tokens.uniqueSize != 6 -> WinningNumbersInput.NUMBERS_COUNT_WRONG
            !tokens.toIntList().isAllInLottoRange() -> WinningNumbersInput.OUT_OF_LOTTO_RANGE
            else -> WinningNumbersInput.VALID
        }
    }

    private fun printWinningNumberContainsNonNumbers() {
        println(ErrorMessage.WINNING_NUMBERS_CONTAINS_NON_NUMBER)
    }

    private fun printWinningNumbersWrongSize() {
        println(ErrorMessage.WINNING_NUMBERS_WRONG_SIZE)
    }

    private fun printWinningNumbersOutOfRange() {
        println(ErrorMessage.WINNING_NUMBERS_OUT_OF_RANGE)
    }

    fun inputToWinningNumbers(input: String): List<Int> {
        return input.split(",").map { it.toInt() }
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        while (true) {
            printBonusNumberMessage()
            val input = Console.readLine()
            when (checkBonusNumberInput(input, winningNumbers)) {
                BonusNumberInput.NOT_INTEGER -> printBonusNumberNotIntegerMessage()
                BonusNumberInput.OUT_OF_RANGE -> printBonusNumberOutOfRangeMessage()
                BonusNumberInput.WINNING_NUMBERS_DUPLICATE -> printBonusNumberIsDuplicateMessage()
                BonusNumberInput.VALID -> return input.toInt()
            }
        }
    }

    private fun printBonusNumberMessage() {
        println(InputMessage.BONUS_NUMBER)
    }

    fun checkBonusNumberInput(input: String, winningNumbers: List<Int>): BonusNumberInput {
        return when {
            !LottoUtil.isStringNumber(input) -> BonusNumberInput.NOT_INTEGER
            !input.toInt().isInLottoRange() -> BonusNumberInput.OUT_OF_RANGE
            input.toInt() in winningNumbers -> BonusNumberInput.WINNING_NUMBERS_DUPLICATE
            else -> BonusNumberInput.VALID
        }
    }

    private fun printBonusNumberNotIntegerMessage() {
        println(ErrorMessage.BONUS_NUMBER_NOT_INTEGER)
    }

    private fun printBonusNumberOutOfRangeMessage() {
        println(ErrorMessage.BONUS_NUMBER_OUT_OF_RANGE)
    }

    private fun printBonusNumberIsDuplicateMessage() {
        println(ErrorMessage.BONUS_NUMBER_DUPLICATE)
    }

}