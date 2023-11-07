package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.enums.PriceInputType
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

}