package lotto.domain

import lotto.resources.Error.CANT_BUY_ERROR
import lotto.resources.Error.CANT_CONTAIN_WINNING_NUMBER_ERROR
import lotto.resources.Error.MISMATCHED_UNIT_ERROR
import lotto.resources.Error.NOT_INT_ERROR
import lotto.resources.Error.NOT_IN_LOTTO_RANGE_ERROR
import lotto.resources.Lotto
import lotto.resources.Lotto.LOTTO_PRISE

fun String.purchaseAmountValidation() {
    requireNotNull(toIntOrNull()) {
        NOT_INT_ERROR
    }

    require(this.toInt() > LOTTO_PRISE) {
        CANT_BUY_ERROR
    }

    require(this.toInt() % LOTTO_PRISE == 0) {
        MISMATCHED_UNIT_ERROR
    }
}

fun String.bonusValidation(winningNumbers: List<Int>) {
    requireNotNull(toIntOrNull()) {
        NOT_INT_ERROR
    }

    require(this.toInt() in Lotto.START_NUMBER..Lotto.END_NUMBER) {
        NOT_IN_LOTTO_RANGE_ERROR
    }

    require(this.toInt() !in winningNumbers) {
        CANT_CONTAIN_WINNING_NUMBER_ERROR
    }
}
