package lotto.util

enum class Exception(private val message: String) {
    INVALID_INTEGER("사용자의 입력이 숫자가 아닙니다."),
    INVALID_RANGE("사용자의 입력이 유효하지 않은 범위의 숫자입니다."),
    INVALID_1000_UNIT("사용자 입력이 1000원 단위가 아닙니다.");

    private val format = "[ERROR]"

    fun getMessage(): String = "$format $message"
}