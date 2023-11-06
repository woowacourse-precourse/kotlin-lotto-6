package util

object Constants {
    const val MSG_INPUT_MONEY = "구입금액을 입력해 주세요."
    const val MSG_INPUT_WIN_NUMBERS = "당첨 번호를 입력해 주세요."
    const val MSG_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요."

    const val MSG_OUTPUT_PURCHASE_RESULT = "개를 구매했습니다."
    const val MSG_OUTPUT_WIN_LOTTO_RESULT = "당첨 통계\n---"

    const val MSG_ERR_ONLY_DIGIT = "[ERROR] 숫자를 입력해주세요."
    const val MSG_ERR_INVALIDATE_INPUT = "[ERROR] 유효하지 않은 입력입니다."
    const val MSG_ERR_PURCHASE_RANGE = "[ERROR] 구매 가능 금액은 1000원 ~ 10만원 입니다."
    const val MSG_ERR_DIVISIBLE_BY_THOUSAND = "[ERROR] 구매 금액은 1000원 단위로 입력해주세요."
    const val MSG_ERR_SIX_DISTINCT_NUMBER = "[ERROR] 로또 번호는 서로 다른 6자리 수만 가능합니다."
    const val MSG_ERR_LOTTO_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
    const val MSG_ERR_LOTTO_NUMBER_BY_COMMA = "숫자가 여러 개인 경우 쉼표(,)로 구분해주세요. 예) 1,2,3,4,5,6"
    const val MSG_ERR_BONUS_NOT_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다."

    const val MONEY_JACKPOT = "2,000,000,000원"
    const val MONEY_SECOND_PRIZE = "30,000,000원"
    const val MONEY_THIRD_PRIZE = "1,500,000원"
    const val MONEY_FOURTH_PRIZE = "50,000원"
    const val MONEY_FIFTH_PRIZE = "5,000원"

    const val MIN_PURCHASE_MONEY = 1000
    const val MAX_PURCHASE_MONEY = 100_000
    const val MIN_LOTTO_RANGE = 1
    const val MAX_LOTTO_RANGE = 45
    const val PROPER_LOTTO_SIZE = 6
}