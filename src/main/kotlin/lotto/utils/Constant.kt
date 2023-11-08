package lotto.utils

object Constant {
    const val LOTTO_PRICE = 1000
    const val LOTTO_NUMBER_SIZE = 6
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45

    const val INVALID_SIZE_EXCEPTION_MESSAGE = "[ERROR] 로또의 숫자 갯수는 6개여야 합니다!"
    const val DUPLICATE_NUMBER_EXCEPTION_MESSAGE = "[ERROR] 중복된 숫자가 존재합니다"
    const val NOT_DIGIT_EXCEPTION_MESSAGE = "[ERROR] 정수가 입력되지 않았습니다!"
    const val BLANK_INPUT_EXCEPTION_MESSAGE = "[ERROR] 비어있는 값을 입력했습니다!"
    const val BONUS_NUMBER_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 보너스 번호가 정답 로또에 중복됩니다!"
    const val WINNING_NUMBERS_NOT_DIGIT_MESSAGE = "[ERROR] 당첨 로또 번호는 정수여야 합니다 !"
}