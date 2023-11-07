package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.LottoUtil.isAllInLottoRange
import lotto.LottoUtil.isAllNumbers
import lotto.LottoUtil.toIntList
import lotto.LottoUtil.uniqueSize
import lotto.enums.PriceInputType
import lotto.enums.WinningNumbersInput
import lotto.messages.ErrorMessage
import lotto.messages.InputMessage

object LottoUserInput {

    fun getPurchasePriceInput(): Int {
        while (true) {
            printPurchasePriceMessage()
            val input = Console.readLine()
            when (checkPriceInput(input)) {
                PriceInputType.NOT_INTEGER -> printPriceFormatErrorMessage()
                PriceInputType.NOT_POSITIVE -> printPriceIsNotPositiveMessage()
                PriceInputType.NOT_MULTIPLE_OF_1000 -> printPriceIsNotMultipleOf1000Message()
                PriceInputType.VALID -> return input.toInt()
            }
        }
    }

    fun checkPriceInput(input: String): PriceInputType {
        return when {
            !LottoUtil.isStringNumber(input) -> PriceInputType.NOT_INTEGER
            input.toInt() <= 0 -> PriceInputType.NOT_POSITIVE
            !LottoUtil.isMultipleOf1000(input.toInt()) -> PriceInputType.NOT_MULTIPLE_OF_1000
            else -> PriceInputType.VALID
        }
    }

    private fun printPurchasePriceMessage() {
        println(InputMessage.PURCHASE_PRICE)
    }

    private fun printPriceFormatErrorMessage() {
        LottoUtil.printErrorMessage(ErrorMessage.PRICE_WRONG_INPUT_FORMAT)
    }

    private fun printPriceIsNotMultipleOf1000Message() {
        LottoUtil.printErrorMessage(ErrorMessage.PRICE_NOT_MULTIPLE_OF_1000)
    }

    private fun printPriceIsNotPositiveMessage() {
        LottoUtil.printErrorMessage(ErrorMessage.PRICE_NOT_POSITIVE_VALUE)
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

}