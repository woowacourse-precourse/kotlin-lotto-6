package lotto.model

import lotto.Constants

class BuyingAmount(
    private val inputData: String
) {
    val amount: Long get() = inputData.toLong()

    init {
        val data = requireNotNull(inputData.toLongOrNull()) {
            BUYING_AMOUNT_ONLY_DIGIT
        }

        require(data > BUYING_AMOUNT_MINIMUM) {
            BUYING_AMOUNT_THAN_ZERO
        }

        require(data % Constants.LOTTO_PRICE == 0L) {
            BUYING_AMOUNT_UNITS
        }
    }

    companion object {
        const val BUYING_AMOUNT_MINIMUM = 0

        const val BUYING_AMOUNT_ONLY_DIGIT = "구입금액은 숫자여야 합니다."
        const val BUYING_AMOUNT_THAN_ZERO = "구입금액은 ${BUYING_AMOUNT_MINIMUM}보다 커야 합니다."
        val BUYING_AMOUNT_UNITS = "구입금액은 %,d 단위여야 합니다.".format(Constants.LOTTO_PRICE)
    }
}