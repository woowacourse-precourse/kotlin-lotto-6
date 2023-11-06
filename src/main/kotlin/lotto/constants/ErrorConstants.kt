package lotto.constants

object ErrorConstants {
    const val MONEY_NOT_NUMBER = "구입 금액은 숫자만 입력해 주세요."
    const val MONEY_TOO_MUCH = "구입 금액이 너무 큽니다."
    const val MONEY_UNDER_PRICE = "최소 구매 금액에 맞게 입력해 주세요."
    const val MONEY_NOT_DIVIDE = "로또 금액에 알맞게 구매해 주세요."

    const val NUMBERS_NOT_LIST = "당첨 번호는 쉼표(,)로 구분된 6개의 숫자로 입력해 주세요."
    const val NUMBERS_NOT_RANGE =
        "당첨 번호는 ${LottoConstants.MIN_LOTTO_NUMBER} ~ ${LottoConstants.MAX_LOTTO_NUMBER} 사이의 숫자로 입력해 주세요."
    const val NUMBERS_DUPLICATE = "당첨 번호는 중복된 숫자가 없게 입력해 주세요."

    const val BONUS_NOT_RANGE =
        "보너스 당첨 번호는 ${LottoConstants.MIN_LOTTO_NUMBER} ~ ${LottoConstants.MAX_LOTTO_NUMBER} 사이의 숫자로 입력해 주세요."
    const val BONUS_DUPLICATE = "보너스 당첨 번호는 당첨 번호와 중복된 숫자가 없게 입력해 주세요."
}