package lotto.validation

enum class MoneyValidation(private val errorMessage: String) {
    ERROR_VALIDATION("Validation Start"),
    EMPTY_MONEY("[ERROR] 값을 입력해 주세요."),
    INCLUDE_BLANK("[ERROR] 공백을 제외 후 입력해 주세요"),
    INCLUDE_CHARACTER("[ERROR] 금액은 숫자만 입력 하셔야 합니다."),
    LESS_MONEY("[ERROR] 로또 구입 최소 금액은 1000원 입니다."),
    MINUS_MONEY("[ERROR] 금액은 양수로 입력 하셔야 합니다."),
    THOUSAND_WON_UNIT("[ERROR] 금액은 천원 단위로 입력 하셔야 합니다.");
    fun getMessage(money: String) {
        when {
            money.isEmpty() -> throw IllegalArgumentException(EMPTY_MONEY.errorMessage)
            money.contains(" ") -> throw IllegalArgumentException(INCLUDE_BLANK.errorMessage)
            money.any { !it.isDigit() } -> throw IllegalArgumentException(INCLUDE_CHARACTER.errorMessage)
            money.toInt() < 0 -> throw IllegalArgumentException(MINUS_MONEY.errorMessage)
            money.toInt() < 1000 -> throw IllegalArgumentException(LESS_MONEY.errorMessage)
            money.toInt() % 1000 != 0 -> throw IllegalArgumentException(THOUSAND_WON_UNIT.errorMessage)
        }
    }
}