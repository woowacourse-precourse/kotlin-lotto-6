package lotto.model

import lotto.model.validation.LottoNumber

data class BonusNumber(
    private val _bonus: String
) {
    val number get() = LottoNumber(_bonus)
}
