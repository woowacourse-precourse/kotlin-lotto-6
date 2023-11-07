package lotto
import camp.nextstep.edu.missionutils.Randoms

class PurchaseAmount(){
    companion object {
        private const val LOTTO_UNIT = 1000
        private const val ZERO = 0
    }

    public fun validateLottoNumbers(purchaseAmount: Int) : Boolean {
        if (purchaseAmount < LOTTO_UNIT) {
            throw IllegalArgumentException(MessageConstants.ERROR_AMOUNT_LESS_THAN_1000)
        } else if (purchaseAmount % LOTTO_UNIT != ZERO) {
            throw IllegalArgumentException(MessageConstants.ERROR_NOT_A_MULTIPLE_OF_1000)
        }
        return true
    }
}
