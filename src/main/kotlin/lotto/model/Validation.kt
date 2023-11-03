package lotto.model

internal fun String.isAmountInThousand() =
    require(this.toInt() % 1000 == 0) { ErrorMessage.IsNotAmountInThousand }
internal enum class ErrorMessage(private val message: String) {
    IsNotAmountInThousand("[ERROR] 구입 금액은 1,000원 단위 이어야 합니다.");
    override fun toString() = message
}