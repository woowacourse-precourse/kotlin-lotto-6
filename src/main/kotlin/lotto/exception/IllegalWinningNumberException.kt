package lotto.exception

class IllegalWinningNumberException : IllegalArgumentException() {
    override val message: String
        get() = "[ERROR] 올바른 숫자를 입력해주세요."
}
