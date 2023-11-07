package lotto.model.seller

import lotto.validPositiveNumber

@JvmInline
value class Money(val value: Int) {

    init {
        value.validPositiveNumber()
    }
}

fun Int.toMoney(): Money = Money(this)