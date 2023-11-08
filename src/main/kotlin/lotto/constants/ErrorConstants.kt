package lotto.constants

import lotto.constants.GameConstants.MAX_NUMBER
import lotto.constants.GameConstants.MIN_NUMBER

object ErrorConstants {
    // Error Messages
    private const val ERROR_PREFIX = "[ERROR] "

    const val INPUT_ERROR_MESSAGE = "${ERROR_PREFIX}잘못된 입력값을 입력했습니다."
    const val UNAVAILABLE_PURCHASE_AMOUNT_ERROR_MESSAGE = "${ERROR_PREFIX}로또 구입 금액은 1000원 이상이어야 합니다."
    const val UNAVAILABLE_PURCHASE_AMOUNT_BY_THOUSAND_ERROR_MESSAGE = "${ERROR_PREFIX}로또 구입 금액은 1000원으로 나누어 떨어져야 합니다."
    const val COUNT_LOTTO_ERROR_MESSAGE = "${ERROR_PREFIX}로또는 6개의 숫자입니다."
    const val DISTINCT_ERROR_MESSAGE = "${ERROR_PREFIX}중복 오류입니다."
    const val DISTINCT_BONUS_NUMBER_ERROR_MESSAGE = "${ERROR_PREFIX}보너스 숫자는 당첨 번호와 중복될 수 없습니다."
    const val EMPTY_INPUT_ERROR_MESSAGE = "${ERROR_PREFIX}입력값이 없습니다."
    const val RANGE_ERROR_MESSAGE = "${ERROR_PREFIX}${MIN_NUMBER}부터 ${MAX_NUMBER} 범위의 수 입니다."
}
