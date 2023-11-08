package lotto

object ErrorMessages {
    const val PRICE_NOT_INT = "[ERROR] 주어진 금액은 정수여야 합니다."
    const val PRICE_IS_NEGATIVE = "[ERROR] 주어진 금액은 음수가 아니여야 합니다."
    const val PRICE_HAS_REMAINDER = "[ERROR] 주어진 금액이 1000의 배수가 아닙니다."
    const val NORMAL_NUMBER_NOT_INT = "[ERROR] 당첨 번호는 정수여야 합니다."
    const val BONUS_NUMBER_NOT_INT = "[ERROR] 보너스 번호는 정수여야 합니다."
    const val NORMAL_NUMBER_COUNT_SHOULD_BE_SIX = "[ERROR] 당첨 번호는 숫자가 6개만 있어야합니다."
    const val NORMAL_NUMBER_SHOULD_BE_UNIQUE = "[ERROR] 당첨 번호는 모두 달라야합니다."
    const val NORMAL_NUMBER_SHOULD_BE_IN_RANGE = "[ERROR] 당첨 번호의 범위는 1 이상 45 미만 이어야합니다."
    const val LOTTO_NUMBER_COUNT_SHOULD_BE_SIX = "[ERROR] 로또 번호는 숫자가 6개만 있어야합니다."
    const val LOTTO_NUMBER_SHOULD_BE_UNIQUE = "[ERROR] 로또 번호는 모두 달라야합니다."
    const val LOTTO_NUMBER_SHOULD_BE_IN_RANGE = "[ERROR] 로또 번호의 범위는 1 이상 45 미만 이어야합니다."
    const val BONUS_NUMBER_SHOULD_BE_UNIQUE = "[ERROR] 보너스 번호는 당첨 번호와 모두 달라야합니다."
    const val BONUS_NUMBER_SHOULD_BE_IN_RANGE = "[ERROR] 보너스 번호의 범위는 1 이상 45 미만 이어야합니다."
}