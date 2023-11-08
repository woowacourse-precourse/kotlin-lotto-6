package lotto.model

import lotto.model.validator.BonusValidation
import lotto.model.validator.BonusValidator

@JvmInline
value class Bonus private constructor(val number: LottoNumber) {

    companion object {
        fun of(numberInput: String, winningNumbers: Lotto, validator: BonusValidator = BonusValidator()): Bonus {
            val lottoNumber = LottoNumber(numberInput)
            validator.validate(BonusValidation(winningNumbers, lottoNumber))
            return Bonus(lottoNumber)
        }
    }
}