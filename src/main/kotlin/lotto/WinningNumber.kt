package lotto

import lotto.ErrorConstants.NUMBER_FORMAT_ERROR

object WinningNumber {

    fun processWinningNumber(userInput: String): Lotto = runCatching {
        val numbers = Converter.convertStringToIntList(userInput)
        Lotto(numbers)
    }.getOrElse { throwable ->
        when (throwable) {
            is NumberFormatException -> throw IllegalArgumentException(NUMBER_FORMAT_ERROR)
            else -> throw IllegalArgumentException(throwable.message)
        }
    }
}
