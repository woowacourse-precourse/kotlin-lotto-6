import lotto.model.LottoNumber

data class BonusNumber(
    private val _bonus: String
) {
    val number get() = LottoNumber(_bonus)
}
