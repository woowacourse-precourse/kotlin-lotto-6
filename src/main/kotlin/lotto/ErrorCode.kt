package lotto

enum class ErrorCode(val message: String) {
    NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_NUMBER_ERROR("[ERROR] 공백 또는 문자열이 아닌 숫자를 입력해주세요."),
    MONEY_UNIT_ERROR("[ERROR] 1000원 단위로 입력해주세요."),
    LENGTH_ERROR("[ERROR] 숫자는 6개를 입력해주세요."),
    DUPLICATE_ERROR("[ERROR] 중복되지 않는 숫자를 입력해주세요.");
}