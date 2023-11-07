package lotto.domain.validator

import lotto.domain.LottoShop
import lotto.domain.validator.InputValidator.validateInputIsInt
import lotto.domain.validator.InputValidator.validateInputIsNotZero

object LottoShopValidator {
    fun validatePurchaseLottoInput(input: String) {
        validateInputIsInt(input, message = "로또 구매 금액은 1000원 단위 정수형만 입력받을 수 있습니다.")
        validateInputIsNotZero(input, message = "로또 구매 금액으로는 0원 은 입력하실 수 없습니다.")
        validateInputIsDivisibleByThousand(input)
    }

    private fun validateInputIsDivisibleByThousand(input: String) =
        require(input.toInt() % LottoShop.LOTTO_PRICE == 0) {
            "[ERROR] 로또 구매 금액으로는 1000원 단위로만 입력받을 수 있습니다."
        }
}