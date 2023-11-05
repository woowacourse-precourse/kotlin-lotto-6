package lotto.domain

import lotto.domain.util.Validator

class Draw {
    fun validateDrawNumber(drawNumber: String): List<Int> {
        return Validator().validateDrawNumber(drawNumber)
    }
}