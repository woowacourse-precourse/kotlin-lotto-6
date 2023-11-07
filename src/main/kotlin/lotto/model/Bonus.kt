package lotto.model

import lotto.validate.ValidateBonus

class Bonus(private val bonusNumber: String) {

    init {
        ValidateBonus().validateBonus(bonusNumber)
    }
    fun getBonus(): Int {
        return bonusNumber.toInt()
    }
}