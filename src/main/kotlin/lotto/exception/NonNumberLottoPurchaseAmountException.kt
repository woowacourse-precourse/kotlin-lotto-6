package lotto.exception

class NonNumberLottoPurchaseAmountException : IllegalArgumentException {
    constructor() : super("로또 구입 금액은 숫자로 입력해야 합니다")
}
