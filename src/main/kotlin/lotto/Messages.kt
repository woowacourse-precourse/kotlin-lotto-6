package lotto

enum class Messages(val message: String) {
    // TEXT
    TEXT_INPUT_LOTTO_AMOUNT("구입 금액을 입력해 주세요."),

    // EXCEPTION
    EXCEPTION_WRONG_RANGE("[ERROR] 구입 금액의 범위는 1,000원 이상 4,611,686,018,000원 이하입니다."),
    EXCEPTION_WRONG_MONEY_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
}