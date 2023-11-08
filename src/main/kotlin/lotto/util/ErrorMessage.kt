package lotto.util

enum class ErrorMessage(private val message: String) {
    NUMBER_UNIT("구매 금액이 1000원 단위가 아닙니다."),
    NUMBER_INTEGER("입력이 숫자가 아닙니다."),
    NUMBER_NATURAL("입력이 자연수가 아닙니다."),
    NUMBER_RANGE("당첨 번호의 범위는 1부터 45입니다."),
    NUMBER_DUPLICATION("당첨 번호는 중복될 수 없습니다."),
    NUMBER_NULL("입력값이 존재하지 않습니다."),
    NUMBER_SIZE("당첨 번호의 개수는 6개입니다.");

    fun getMessage(): String = "[ERROR] $message"
}