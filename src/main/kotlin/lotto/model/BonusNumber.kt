package lotto.model

import lotto.exception.DuplicatedNumberException
import lotto.exception.UnvalidLottoNumberException

class BonusNumber(private val bonusNumber: Int) {

    fun getBonusNumber(): Int {
        return bonusNumber
    }
}