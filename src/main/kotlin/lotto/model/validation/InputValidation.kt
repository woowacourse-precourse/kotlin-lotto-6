package lotto.model.validation

import lotto.model.LottoNumValidation

class InputValidation {

    companion object {
        private const val DIVISION_NUM = 1000
        const val DIVISION_BY_THOUSAND_ERROR = "[ERRPR] 로또는 ${DIVISION_NUM}원 단위로 구매 가능합니다."
        const val INPUT_ZERO_AMOUNT = "[ERRPR] 로또 구매 금액으로 0을 입력할 수 없습니다."
        const val INPUT_NEGATIVE_AMOUNT = "[ERRPR] 로또 구매 금액으로 0을 입력할 수 없습니다."
    }

    fun validateLottoPurchaseAmount(amount: Int) {
        isLottoPurchaseAmountDivisibleByThousand(amount)
        isLottoPurchaseAmountNotZero(amount)
        isLottoPurchaseAmountNotPositive(amount)
    }

    private fun isLottoPurchaseAmountDivisibleByThousand(amount: Int) {
        require(amount % DIVISION_NUM != 0) { DIVISION_BY_THOUSAND_ERROR }
    }

    private fun isLottoPurchaseAmountNotZero(amount: Int) {
        require(amount != 0) { INPUT_ZERO_AMOUNT }
    }

    private fun isLottoPurchaseAmountNotPositive(amount: Int) {
        require(amount > 0) { INPUT_NEGATIVE_AMOUNT }
    }
}