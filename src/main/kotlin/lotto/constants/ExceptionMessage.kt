package lotto.constants

object ExceptionMessage {
  private const val PREFIX_OF_EXCEPTION_MESSAGE = "[ERROR] "
  const val ENTER_CORRECT_PURCHASE_MONEY = PREFIX_OF_EXCEPTION_MESSAGE + "올바른 구입금액을 입력해주세요."
  const val ENTER_MULTIPLE_OF_LOTTO_TICKET_PRICE = PREFIX_OF_EXCEPTION_MESSAGE + "구입 금액을 " + Lotto.LOTTO_PRICE + "원 단위로 입력해주세요."
}