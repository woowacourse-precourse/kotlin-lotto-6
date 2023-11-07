package lotto.model

import lotto.utils.Values

class BonusNumber(private val bonusNumber: Int) {
    init {
        require(Values.MINIMUM_LOTTERY_NUMBER <= bonusNumber && bonusNumber <= Values.MAXIMUM_LOTTERY_NUMBER)
    }
}
