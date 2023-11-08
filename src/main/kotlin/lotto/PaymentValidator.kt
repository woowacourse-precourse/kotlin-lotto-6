package lotto

class PaymentValidator(private val input:String) {

    private val errorHandler = ErrorHandler()

    fun isValid(): Boolean = errorHandler.checkWithExceptionHandler(this::validateIsNumber, ErrorMessage.INVALID_PAYMENT_NUMBER.message, ErrorType.NumberFormatException) &&
            errorHandler.checkWithExceptionHandler(this::validateIsUpperToThousand, ErrorMessage.INVALID_MINIMUM_PAYMENT.message, ErrorType.IllegalArgumentException) &&
            errorHandler.checkWithExceptionHandler(this::validateIsCorrectUnit, ErrorMessage.DIVIDE_TO_THOUSAND.message, ErrorType.IllegalArgumentException)

    private fun validateIsNumber(): Boolean = input.toIntOrNull() is Int

    private fun validateIsUpperToThousand(): Boolean {
        val payment = input.toInt()
        return payment >= 1_000
    }

    private fun validateIsCorrectUnit(): Boolean {
        val payment = input.toInt()
        return payment % 1_000 == 0
    }

}