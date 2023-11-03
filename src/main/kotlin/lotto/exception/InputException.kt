package lotto.exception

enum class InputException(val message: String) {
    STRING_BLANK("[ERROR] 빈 값이 입력되었습니다."),
    NOT_INTEGER("[ERROR] 숫자를 입력해주세요.")
}