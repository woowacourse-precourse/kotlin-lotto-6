package lotto.model

class PurchaseAmount(
    private val _data: String
) {
    val data: Int get() = _data.toInt()

    init {
        val data = requireNotNull(_data.toIntOrNull()) {
            ERROR_MESSAGE_PURCHASE_AMOUNT_ONLY_DIGIT
        }

        require(data > PURCHASE_AMOUNT_MINIMUM) { ERROR_MESSAGE_PURCHASE_AMOUNT_THAN_ZERO }

        require(data % PURCHASE_AMOUNT_UNIT == 0) { ERROR_MESSAGE_PURCHASE_AMOUNT_UNITS }
    }

    companion object {
        const val PURCHASE_AMOUNT_MINIMUM = 0
        const val PURCHASE_AMOUNT_UNIT = 1000

        const val ERROR_MESSAGE_PURCHASE_AMOUNT_ONLY_DIGIT = "구입금액은 숫자여야 합니다."
        const val ERROR_MESSAGE_PURCHASE_AMOUNT_THAN_ZERO = "구입금액은 0보다 커야 합니다."
        const val ERROR_MESSAGE_PURCHASE_AMOUNT_UNITS = "구입금액은 $PURCHASE_AMOUNT_UNIT 단위여야 합니다."
    }
}