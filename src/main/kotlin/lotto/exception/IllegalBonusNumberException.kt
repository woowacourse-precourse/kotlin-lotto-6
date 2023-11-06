package lotto.exception

class IllegalBonusNumberException : IllegalArgumentException() {
    override val message: String
        get() = "[ERROR] 올바른 숫자를 입력해주세요."
}
