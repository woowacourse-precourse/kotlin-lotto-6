package lotto.model

import lotto.model.validation.LottoNumber

class BonusNumber(
    private val _bonus: String
) {
    val number: LottoNumber

    init {
        number = LottoNumber(_bonus)
    }
}