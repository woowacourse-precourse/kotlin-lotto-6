package lotto.exception

class IllegalPurchaseAmountException : IllegalArgumentException() {
    override val message: String
        get() = "[ERROR] 올바른 금액을 입력해주세요."
}
