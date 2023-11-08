package lotto

enum class UserInputMsg(val msg: String) {
    MONEY("구입금액을 입력해 주세요."),
    LOTTO("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요.")
}