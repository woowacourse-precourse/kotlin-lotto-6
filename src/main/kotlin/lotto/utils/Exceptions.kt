package lotto.utils

object Exceptions {

    // 구입 금액 예외처리
    fun validatePurchaseAmount(input: String?): Int? {
        when {
            input == null ->{
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE)
            }
            input.toIntOrNull() == null || input.any() { !it.isDigit() } -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE_IS_NOT_DIGIT)
            }
             input.toInt() % 1000 != 0 -> {
                throwIllegalArgumentException(CommonConst.ILLEGAL_ARGUMENT_EXCEPTION_PURCHASE)
            }
        }
        return input?.toInt()
    }

    private fun throwIllegalArgumentException(message: String) {
        throw IllegalArgumentException(message)
    }
}

