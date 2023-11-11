package lotto.domain

import lotto.constants.*

fun moneyErrorCheck(moneyInput: String) {
    blankCheck(moneyInput)
    numberCheck(moneyInput)
    moneyNegativeCheck(moneyInput.toInt())
    moneyCheck(moneyInput.toInt())
}

fun blankCheck(input: String) {
    if (input.isBlank()) {
        throw IllegalArgumentException(BLANK_ERROR)
    }
}

fun numberCheck(input: String) {
    if (input.toIntOrNull() == null) {
        throw IllegalArgumentException(NUMBER_ERROR)
    }
}

fun moneyCheck(money: Int) {
    if (money % MONEY_UNIT != 0) {
        throw IllegalArgumentException(MONEY_ERROR)
    }
}

fun moneyNegativeCheck(money: Int) {
    if (money <= 0) {
        throw IllegalArgumentException(NEGATIVE_ERROR)
    }
}