package lotto

class Validator(private val input: String) {
    fun isPaymentValid(): Boolean = ErrorHandler().checkWithExceptionHandler(this::validateIsNumber, INVALID_PAYMENT_NUMBER, ErrorType.NumberFormatException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsUpperToThousand, INVALID_MINIMUM_PAYMENT, ErrorType.IllegalArgumentException) &&
            ErrorHandler().checkWithExceptionHandler(this::validateIsCorrectUnit, DIVIDE_TO_THOUSAND, ErrorType.IllegalArgumentException)

    private fun validateIsNumber(): Boolean = input.toIntOrNull() is Int
    private fun validateIsUpperToThousand(): Boolean {
        val payment = input.toInt()
        return payment >= 1000
    }

    private fun validateIsCorrectUnit(): Boolean {
        val payment = input.toInt()
        return payment % 1_000 == 0
    }


    companion object {
        const val INVALID_PAYMENT_NUMBER = "지불금액은 숫자로만 입력가능합니다."
        const val INVALID_MINIMUM_PAYMENT = "최소 지불 금액은 1000원입니다."
        const val DIVIDE_TO_THOUSAND = "지불 금액은 1000원 단위로 입력되어야 합니다."
    }
}