package lotto.exception

enum class MoneyException(val message: String) {
    NOT_POSITIVE_NUMBER("[ERROR] 금액은 음수가 될 수 없습니다.")
}