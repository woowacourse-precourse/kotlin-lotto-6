package lotto.model

import lotto.Constants

class PurchaseAmount(
    private val _data: String
) {
    val amount: Int get() = _data.toInt()

    init {
        val data = requireNotNull(_data.toIntOrNull()) {
            ERROR_MESSAGE_PURCHASE_AMOUNT_ONLY_DIGIT
        }

        require(data > PURCHASE_AMOUNT_MINIMUM) { ERROR_MESSAGE_PURCHASE_AMOUNT_THAN_ZERO }

        require(data % Constants.LOTTO_PRICE == 0) { ERROR_MESSAGE_PURCHASE_AMOUNT_UNITS }
    }

    companion object {
        const val PURCHASE_AMOUNT_MINIMUM = 0

        const val ERROR_MESSAGE_PURCHASE_AMOUNT_ONLY_DIGIT = "구입금액은 숫자여야 합니다."
        const val ERROR_MESSAGE_PURCHASE_AMOUNT_THAN_ZERO = "구입금액은 0보다 커야 합니다."
        const val ERROR_MESSAGE_PURCHASE_AMOUNT_UNITS =
            "구입금액은 ${Constants.LOTTO_PRICE} 단위여야 합니다."
    }
}