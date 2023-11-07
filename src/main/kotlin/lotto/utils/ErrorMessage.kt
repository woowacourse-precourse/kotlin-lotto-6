package lotto.utils

object ErrorMessage {
    const val TITLE = "[ERROR]"
    const val INAPPROPRIATE_MONEY_VALUE = "구입금액은 1000 단위의 자연수 입력이여야 합니다."
    const val INAPPROPRIATE_LOTTO_VALUE = """당첨 번호는 다음의 규칙을 따릅니다 : 
    1. ${Values.LOTTERY_NUMBER_AMOUNT}개의 수가 중복 없이 작성되어야 합니다.
    2. 각 수는 ${Values.MINIMUM_LOTTERY_NUMBER} 이상 ${Values.MAXIMUM_LOTTERY_NUMBER} 이하여야 합니다.
    3. 각 수는 공백 없이 쉼표로 구분되어야 합니다."""
    const val INAPPROPRIATE_BONUS_VALUE_NAN = "보너스 번호 입력은 ${Values.MINIMUM_LOTTERY_NUMBER} 이상 ${Values.MAXIMUM_LOTTERY_NUMBER} 이하의 당첨 번호가 아닌 숫자만 허용됩니다."
}