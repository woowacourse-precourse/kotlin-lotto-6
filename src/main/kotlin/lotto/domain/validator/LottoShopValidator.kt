package lotto.domain.validator

import lotto.domain.LottoShop
import lotto.domain.validator.InputValidator.validateInputIsInt
import lotto.domain.validator.InputValidator.validateInputIsNotZero

class LottoShopValidator {
    fun validatePurchaseLottoInput(input: String) = input.let {
        validateInputIsInt(it, message = "로또 구매 금액은 1000원 단위 정수형만 입력받을 수 있습니다.")
        validateInputIsNotZero(it, message = "로또 구매 금액으로는 0원 은 입력하실 수 없습니다.")
        validateInputIsDivisibleByThousand(it)
    }

    private fun validateInputIsDivisibleByThousand(input: String) {
        require(input.toInt() % LottoShop.LOTTO_PRICE == 0) {
            "[ERROR] 로또 구매 금액으로는 1000원 단위로만 입력받을 수 있습니다."
        }
    }
}