package lotto.exception

import lotto.util.Constants

class IllegalPurchaseAmountException : IllegalArgumentException() {
    override val message: String
        get() = "${Constants.ERROR} 올바른 금액을 입력해주세요."
}
