package lotto

enum class State(val value: Int) {
    FIRST(6), SECOND(7), THIRD(5), FOURTH(4), FIFTH(5)
}

enum class Message(val msg: String) {
    INQUIRE_MONEY("구입금액을 입력해 주세요."),
    PRINT_LOTTO("개를 구매했습니다."),
    INQUIRE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
}