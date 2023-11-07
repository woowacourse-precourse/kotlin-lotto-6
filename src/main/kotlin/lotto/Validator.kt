package lotto

class Validator(private val input: String) {

    fun isPaymentValid(): Boolean = checkIsNumber() && checkIsUpperToThousand() && checkIsCorrectUnit()

    private fun checkIsNumber(): Boolean {
        return try {
            validateIsNumber()
            true
        } catch (e: NumberFormatException) {
            ErrorPrinter.printError(INVALID_PAYMENT_NUMBER)
            false
        }
    }

    private fun validateIsNumber() {
        if (input.toIntOrNull() !is Int) throw NumberFormatException(INVALID_PAYMENT_NUMBER)
    }

    private fun checkIsUpperToThousand(): Boolean {
        val payment = input.toInt()
        return try {
            validateIsUpperToThousand(payment)
            true
        } catch (e: IllegalArgumentException) {
            ErrorPrinter.printError(INVALID_MINIMUM_PAYMENT)
            false
        }
    }

    private fun validateIsUpperToThousand(payment: Int) {
        if (payment < 1000) throw IllegalArgumentException(INVALID_MINIMUM_PAYMENT)
    }

    private fun checkIsCorrectUnit(): Boolean {
        val payment = input.toInt()
        return try {
            validateIsCorrectUnit(payment)
            true
        } catch (e: IllegalArgumentException) {
            ErrorPrinter.printError(DIVIDE_TO_THOUSAND)
            false
        }
    }

    private fun validateIsCorrectUnit(payment: Int) {
        if (payment % 1_000 != 0) throw IllegalArgumentException(DIVIDE_TO_THOUSAND)
    }

    companion object {
        const val INVALID_PAYMENT_NUMBER = "지불금액은 숫자로만 입력가능합니다."
        const val INVALID_MINIMUM_PAYMENT = "최소 지불 금액은 1000원입니다."
        const val DIVIDE_TO_THOUSAND = "지불 금액은 1000원 단위로 입력되어야 합니다."
    }
}