package lotto.domain

enum class ValidatorPayment(val message: String) {
    INVALID_FORMAT("[ERROR] 1000원 단위의 숫자로만 구입금액을 재입력해 주세요."),
    INVALID_RANGE("[ERROR] 1000원 단위의 양수 구입금액을 재입력해 주세요."),
    INVALID_AMOUNT("[ERROR] 1000원 단위로 구입금액을 재입력해 주세요.");
}

enum class ValidatorNumbers(val message: String) {
    INVALID_FORMAT("[ERROR] 숫자만을 당첨 번호로 재입력해주세요."),
    INVALID_RANGE("[ERROR] 1 ~ 45 숫자만을 당첨 번호로 재입력해주세요."),
    INVALID_SIZE("[ERROR] 6개의 번호만 재입력해주세요."),
    INVALID_DUPLICATE("[ERROR] 중복된 숫자가 없게 재입력해주세요.")
}

enum class ValidatorBonus(val message: String) {
    INVALID_FORMAT("[ERROR] 숫자만을 보너스 번호로 재입력해주세요."),
    INVALID_RANGE("[ERROR] 1 ~ 45 숫자만을 당첨 번호로 재입력해주세요."),
    INVALID_DUPLICATE("[ERROR] 당첨 번호들과 중복되지 않는 보너스 번호를 재입력해주세요."),
}