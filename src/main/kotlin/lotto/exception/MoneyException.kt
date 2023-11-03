package lotto.exception

enum class MoneyException(val message: String) {
    NOT_DIVISIBLE("[ERROR] 구입금액은 %d원 단위로 입력해야 합니다."),
    LESS_THAN_DIVISOR("[ERROR] 구입금액은 최소 %d원 이상 입력해야 합니다.");

    fun getDivisor(divisor: Int): String = message.format(divisor)
}