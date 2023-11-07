package lotto.constants

object ExceptionMessages {
    const val ERROR = "[ERROR]"

    const val EXCEPTION_PURCHASE_DIVISION = "로또 한 장의 가격은 1,000원으로, 구입 금액은 1,000으로 나누어 떨어져야 합니다."
    const val EXCEPTION_PURCHASE_NO_MORE_THAN_ZERO = "구입 금액은 0 이하가 될 수 없습니다."
    const val EXCEPTION_PURCHASE_STRING = "문자열을 구매 금액으로 입력할 수 없습니다."

    const val EXCEPTION_WINNING_NUMBERS_SIZE = "당첨 번호로 6개를 입력해야 합니다."
    const val EXCEPTION_WINNING_NUMBERS_DUPLICATED = "당첨 번호는 중복될 수 없습니다."
    const val EXCEPTION_WINNING_NUMBERS_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val EXCEPTION_WINNING_NUMBERS_TYPE = "당첨 번호로 문자열을 입력할 수 없습니다."

    const val EXCEPTION_BONUS_NUMBER_RANGE = "로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val EXCEPTION_BONUS_NUMBER_TYPE = "보너스 번호로 문자열을 입력할 수 없습니다."
    const val EXCEPTION_BONUS_NUMBER_DUPLICATED = "보너스 번호가 이미 당첨 번호에 존재합니다."

    const val EXCEPTION_UNEXPECTED = "알 수 없는 에러가 발생하였습니다."
}