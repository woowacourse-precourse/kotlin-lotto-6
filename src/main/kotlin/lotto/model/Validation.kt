package lotto.model

internal fun String.isAmountInThousand() =
    require(this.toInt() % 1000 == 0) { ErrorMessage.IsNotAmountInThousand }

internal fun String.isDigit() =
    requireNotNull(this.toIntOrNull()) { ErrorMessage.IsDigit }

internal fun String.isLessThanThousand() =
    require(this.toInt() >= 1000) { ErrorMessage.IsLessThanThousand }

internal fun List<String>.lottoSize() =
    require(this.size == 6) { ErrorMessage.LottoSize }

internal fun String.isLottoNumber() =
    require(this.toInt() in 1..45) { ErrorMessage.IsLottoNumber }

internal enum class ErrorMessage(private val message: String) {
    IsNotAmountInThousand("[ERROR] 구입 금액은 1,000원 단위 이어야 합니다."),
    IsDigit("[ERROR] 구입 금액은 숫자 이어야 합니다."),
    IsLessThanThousand("[ERROR] 구입 금액은 1000원 이상 이어야 합니다."),
    LottoSize("[ERROR] 당첨 번호는 6개의 숫자 이어야 합니다."),
    IsLottoNumber("[ERROR] 당첨 번호는 1 ~ 45 까지 숫자 이어야 합니다.");

    override fun toString() = message
}