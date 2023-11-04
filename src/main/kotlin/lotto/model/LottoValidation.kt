package lotto.model

class LottoNumValidation {
    fun validateLottoNum(input: List<Int>) {
        checkLottoNumSize(input)
        checkForDuplicateLottoNumbers(input)
        checkLottoNumRange(input)
    }

    private fun checkLottoNumSize(input: List<Int>) {
        require(input.size == 6) { LOTTO_NUM_SIZE_ERROR }
    }

    private fun checkForDuplicateLottoNumbers(input: List<Int>) {
        require(input.size == input.distinct().count()) { DUPLICATE_LOTTO_NUM_ERROR }
    }

    private fun checkLottoNumRange(input: List<Int>) {
        require(input.all { it in MIN_LOTTO_NUM..MAX_LOTTO_NUM }) { LOTTO_NUM_RANGE_ERROR }
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

    companion object {
        const val MAX_LOTTO_NUM = 45
        const val MIN_LOTTO_NUM = 1
        const val LOTTO_NUM_SIZE_ERROR = "[ERROR] 로또 번호의 숫자의 개수는 6개입니다."
        const val DUPLICATE_LOTTO_NUM_ERROR = "[ERROR] 로또 번호는 중복될 수 없습니다."
        const val LOTTO_NUM_RANGE_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."

        const val DIVISION_NUM = 1000
        const val DIVISION_BY_THOUSAND_ERROR = "[ERRPR] 로또는 ${DIVISION_NUM}원 단위로 구매 가능합니다."
        const val INPUT_ZERO_AMOUNT = "[ERRPR] 로또 구매 금액으로 0을 입력할 수 없습니다."
        const val INPUT_NEGATIVE_AMOUNT = "[ERRPR] 로또 구매 금액으로 0을 입력할 수 없습니다."

    }
}