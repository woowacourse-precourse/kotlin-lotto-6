package lotto

enum class State(val value: Int, val price: Int) {
    FIRST(6, 2000000000),
    SECOND(7, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000)
}

enum class Message(val msg: String) {
    INQUIRE_MONEY("구입금액을 입력해 주세요."),
    PRINT_LOTTO("개를 구매했습니다."),
    INQUIRE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INQUIRE_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ERROR_MESSAGE("[ERROR]")
}