package lotto

enum class Error(val message: String) {
    NotNumber("[ERROR] 숫자를 입력해 주세요."),
    InvalidUnit("[ERROR] 1000원 단위로 입력해 주세요."),
}