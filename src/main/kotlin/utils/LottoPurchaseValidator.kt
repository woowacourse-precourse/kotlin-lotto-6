package utils

class LottoPurchaseValidator : IntegerInputValidator() {

    fun checkInputValidation(input: String): Boolean {
        this.validateIsString(input)
        this.validateIsNegative(input)
        this.validateIsZero(input)
        validateInvalidPurchaseAmount(input)
        return true
    }

    fun validateInvalidPurchaseAmount(input: String) {
        require(((input.toInt()) % WON_PER_LOTTO) == 0) { INPUT_INVALID_AMOUNT_ERR_MSG }
    }

    companion object {
        const val WON_PER_LOTTO = 1000
        const val INPUT_INVALID_AMOUNT_ERR_MSG = "로또의 구입 금액 단위는 1,000원 입니다."
    }
}