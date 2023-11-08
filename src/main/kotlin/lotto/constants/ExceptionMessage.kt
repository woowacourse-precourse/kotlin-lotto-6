package lotto.constants

import lotto.constants.Lotto.LOTTO_COUNT

object ExceptionMessage {
  private const val PREFIX_OF_EXCEPTION_MESSAGE = "[ERROR] "
  const val WRONG_PURCHASE_MONEY = PREFIX_OF_EXCEPTION_MESSAGE + "올바른 구입금액을 입력해주세요."
  const val NOT_MULTIPLE_OF_LOTTO_TICKET_PRICE = PREFIX_OF_EXCEPTION_MESSAGE + "구입 금액을 " + Lotto.LOTTO_PRICE + "원 단위로 입력해주세요."

  const val LESS_NUMBERS_THAN_LOTTO_COUNT = PREFIX_OF_EXCEPTION_MESSAGE + "중복되지 않는 " + LOTTO_COUNT.toString() + "개의 당첨 번호를 1부터 45 사이의 숫자로 쉼표(,)와 함께 구분지어 입력해주세요."
  const val NOT_INTEGER_NUMBERS = "로또 번호는 정수여야 합니다."
  const val OUT_OF_RANGE_NUMBERS = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
  const val NOT_UNIQUE_NUMBERS = "로또 번호는 중복되지 않는 숫자여야 합니다."
}