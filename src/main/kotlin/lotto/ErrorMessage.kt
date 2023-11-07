package lotto

enum class ErrorMessage(val message: String) {
    INVALID_PAYMENT_NUMBER("지불금액은 숫자로만 입력가능합니다."),
    INVALID_MINIMUM_PAYMENT("최소 지불 금액은 1000원입니다."),
    DIVIDE_TO_THOUSAND("지불 금액은 1000원 단위로 입력되어야 합니다."),
    COMMA_START("처음에 콤마가 추가되었습니다. 콤마로 입력을 시작해서는 안됩니다."),
    COMMA_END("콤마로 입력이 끝나서는 안됩니다."),
    INVALID_WINNING_NUMBER("당첨번호는 숫자로만 입력되어야합니다."),
    SAME_NUMBER("중복된 숫자가 있으면 안됩니다."),
    LOTTO_NUMBER_COUNT("6개의 숫자가 입력되어야 합니다."),
    NUMBER_RANG("1과 45 사이의 숫자가 입력되어야 합니다."),
    INVALID_BONUS_NUMBER("보너스 볼은 숫자로만 입력되어야합니다."),
    SAME_WITH_WINNING_NUMBER("당첨 번호와 중복되어서는 안됩니다.")
}
