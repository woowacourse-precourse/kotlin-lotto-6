package lotto.domain

import lotto.utils.Constant.LOTTO_PRICE

private const val ZERO = 0

private const val INSUFFICIENT_FUNDS_MESSAGE = "[ERROR] 로또 구입금액은 1000원 이상이어야 합니다!"
private const val EXCESSIVE_PAYMENT_MESSAGE = "[ERROR] 1000원 단위로 구매 가능합니다!"

class Money(val value: Int) {

    init {
        require(value >= LOTTO_PRICE) { INSUFFICIENT_FUNDS_MESSAGE }
        require(value % LOTTO_PRICE == ZERO) { EXCESSIVE_PAYMENT_MESSAGE }
    }

}