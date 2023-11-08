package lotto.exception

class NonDivisibleLottoPurchaseAmountException : IllegalArgumentException {
    constructor() : super("로또 구입 금액은 1,000원 단위로 입력해야 합니다.")
}
