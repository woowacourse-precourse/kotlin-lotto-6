package lotto.utils

import lotto.constants.ExceptionMessage.WRONG_PURCHASE_MONEY
import lotto.constants.ExceptionMessage.NOT_MULTIPLE_OF_LOTTO_TICKET_PRICE
import lotto.constants.Lotto.LOTTO_PRICE

object LottoPurchaseExceptionHandler {

  fun validateInputPurchaseMoney(inputPurchaseMoney: String): Long {
    val integerLongPurchaseMoney = validateIntegerLong(inputPurchaseMoney)

    return validateCorrectPurchaseMoney(integerLongPurchaseMoney)
  }

  private fun validateCorrectPurchaseMoney(integerLongPurchaseMoney: Long): Long {
    validateNonNegativeInteger(integerLongPurchaseMoney)
    validateMultipleOfLottoTicketPrice(integerLongPurchaseMoney)

    return integerLongPurchaseMoney
  }

  private fun validateMultipleOfLottoTicketPrice(integerLongPurchaseMoney: Long) {
    if (integerLongPurchaseMoney % LOTTO_PRICE != 0L) {
      throw IllegalArgumentException(NOT_MULTIPLE_OF_LOTTO_TICKET_PRICE)
    }
  }

  private fun validateNonNegativeInteger(integerLongPurchaseMoney: Long) {
    if (integerLongPurchaseMoney < 0) {
      throw IllegalArgumentException(WRONG_PURCHASE_MONEY)
    }
  }

  private fun validateIntegerLong(inputPurchaseMoney: String): Long {
    val trimmedInputPurchaseMoney = trimPurchaseMoney(inputPurchaseMoney)

    return trimmedInputPurchaseMoney.toLongOrNull()
      ?: throw IllegalArgumentException(WRONG_PURCHASE_MONEY)
  }

  private fun trimPurchaseMoney(inputPurchaseMoney: String): String {
    return inputPurchaseMoney
      .replace(",", "")
      .replace(" ", "")
      .replace("_", "")
  }
}