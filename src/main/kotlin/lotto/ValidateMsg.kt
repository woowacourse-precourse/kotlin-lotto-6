package lotto

enum class ValidateMsg(val msg: String) {
    REDUNDANT("중복되지 않는 번호를 입력하여 주세요."),
    LOTTONUM("로또 번호는 6개입니다."),
    NUMRANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다.")
}