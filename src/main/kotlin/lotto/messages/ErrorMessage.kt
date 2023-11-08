package lotto.messages

object ErrorMessage {

    const val AMOUNT_WRONG_INPUT_FORMAT = "[ERROR] 구입 금액에 정수를 입력해야 합니다."
    const val AMOUNT_NOT_MULTIPLE_OF_1000 = "[ERROR] 구입 금액은 1,000의 배수여야 합니다."
    const val AMOUNT_NOT_POSITIVE_VALUE = "[ERROR] 구입 금액은 0보다 큰 1,000의 배수여야 합니다."

    const val WINNING_NUMBERS_CONTAINS_NON_NUMBER = "[ERROR] 당첨 번호는 숫자로 입력해 주세요."
    const val WINNING_NUMBERS_WRONG_SIZE = "[ERROR] 서로 다른 당첨 번호를 6개 입력해 주세요."
    const val WINNING_NUMBERS_OUT_OF_RANGE = "[ERROR] 당첨 번호는 1 이상 45 이하여야 합니다."

    const val BONUS_NUMBER_NOT_INTEGER = "[ERROR] 입력한 보너스 번호가 숫자가 아닙니다. 숫자를 입력해 주세요."
    const val BONUS_NUMBER_OUT_OF_RANGE = "[ERROR] 보너스 번호는 1 이상 45 이하여야 합니다."
    const val BONUS_NUMBER_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다."

}