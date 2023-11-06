package lotto.util

enum class LottoException(private val message: String) {
    INVALID_INTEGER("사용자의 입력이 숫자가 아닙니다."),
    INVALID_RANGE("사용자의 입력이 유효하지 않은 범위의 숫자입니다."),
    INVALID_1000_UNIT("사용자 입력이 1000원 단위가 아닙니다."),
    INVALID_LOTTO_LENGTH("당첨번호의 숫자가 6자리가 아닙니다."),
    INVALID_LOTTO_UNIQUE("당첨번호의 숫자에 중복이 존재합니다."),
    INVALID_LOTTO_RANGE("번호가 1부터 45까지의 숫자가 아닙니다."),
    INVALID_NOT_NULL("사용자의 입력이 널값입니다."),
    DUPLICATED_NUMBER("중복된 입력입니다.");

    fun getMessage(): String = "[ERROR] $message"
}