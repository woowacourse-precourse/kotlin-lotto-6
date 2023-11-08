package lotto.config

import lotto.config.GameConfigValue.LOTTO_DEFAULT_DIGIT
import lotto.config.GameConfigValue.MINIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.MAXIMUM_LOTTO_NUMBER
import lotto.config.GameConfigValue.PURCHASE_AMOUNT_UNIT

object ExceptionMessage {
    const val UNIT_ERROR="[ERROR] 구입 금액은 ${PURCHASE_AMOUNT_UNIT}원 단위로 입력해 주세요."
    const val LOTTO_RANGE_ERROR="[ERROR] 로또 번호는 ${MINIMUM_LOTTO_NUMBER}부터 ${MAXIMUM_LOTTO_NUMBER}사이의 숫자여야 합니다."
    const val LOTTO_DEFAULT_DIGIT_ERROR="[ERROR] 당첨 번호는 ${LOTTO_DEFAULT_DIGIT}개의 수 입니다."
    const val DUPLICATE_VALUES="[ERROR] 당첨 번호나 보너스 번호는 중복될 수 입력할 수 없습니다."
 }