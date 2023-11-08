package lotto.domain

enum class Number(message: String) {
    EMPTY("[ERROR] 공백을 제외하고 입력해 주세요."),
    NON_INTEGER("[ERROR] 정수로 입력해 주세요."),
    INVALID_RANGE("[ERROR] 1 ~ 45 사이의 정수만 입력해 주세요.")
}