package lotto.exception

class NonPositiveLottoPurchaseAmountException : IllegalArgumentException {
    constructor() : super("최소 로또 구입 금액은 1000원입니다")
}