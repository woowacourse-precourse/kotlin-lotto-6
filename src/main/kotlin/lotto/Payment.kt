package lotto

class Payment(private val payment: String) {

    init {
        require(isNumber()) { NOT_NUMBER_ERROR }
        require(isLottoUnit(payment)) { NOT_LOTTO_UNIT_ERROR }
    }

    private fun isNumber(): Boolean {
        return payment.toIntOrNull() != null
    }

    private fun isLottoUnit(payment: String): Boolean {
        return payment.toInt() % LOTTO_UNITS == 0
    }

    fun getPayment(): Int {
        return payment.toInt()
    }

    companion object {
        const val LOTTO_UNITS = 1000
        const val NOT_LOTTO_UNIT_ERROR = "[ERROR] 1000원 단위로 입력해주세요"
        const val NOT_NUMBER_ERROR = "[ERROR] 숫자만 입력해주세요"
    }
}