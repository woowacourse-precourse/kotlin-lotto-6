package lotto.constants

import lotto.constants.GameConstants.MAX_LOTTO_NUMBER
import lotto.constants.GameConstants.MIN_LOTTO_NUMBER

object ErrorConstants {
    // Error Messages
    private const val ERROR_PREFIX = "[ERROR] "

    const val INPUT_ERROR_MESSAGE = "${ERROR_PREFIX}잘못된 입력값을 입력했습니다."
    const val NOT_NUMBER_ERROR_MESSAGE = "${ERROR_PREFIX}입력값이 숫자가 아닙니다."
    const val DISTINCT_ERROR_MESSAGE = "${ERROR_PREFIX}중복된 이름이 존재합니다."
    const val RANGE_ERROR_MESSAGE = "${ERROR_PREFIX}${MIN_LOTTO_NUMBER}보다 작거나 ${MAX_LOTTO_NUMBER}보다 큰 수는 입력할 수 없습니다."
}
