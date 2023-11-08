package lotto.enumeration

enum class Bonus(val value: String) {
    NUMBER_INPUT("보너스 번호를 입력해 주세요."),
    ERROR_NOT_INTEGER("[ERROR] 당첨 번호는 정수여야 합니다."),
    ERROR_NOT_RANGE("[ERROR] 당첨 번호는 1 ~ 45 사이여야 합니다."),
    ERROR_NOT_SIX("[ERROR] 당첨 번호는 6개여야 합니다."),
    ERROR_NOT_UNIQUE("[ERROR] 당첨 번호는 중복되지 않아야 합니다.")
}