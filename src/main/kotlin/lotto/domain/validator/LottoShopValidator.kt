package lotto.domain.validator

import lotto.domain.LottoShop

class LottoShopValidator {
    fun validatePurchaseLottoInput(input: String) = input.let {
        validateInputIsInt(it)
        validateInputIsNotZero(it)
        validateInputIsDivisibleByThousand(it)
    }

    private fun validateInputIsInt(input: String) = requireNotNull(input.toIntOrNull()) {
        "로또 구매 금액은 1000원 단위 정수형만 입력받을 수 있습니다."
    }

    private fun validateInputIsNotZero(input: String) = require(input.toInt() != 0) {
        "로또 구매 금액으로는 0원 은 입력하실 수 없습니다."
    }

    private fun validateInputIsDivisibleByThousand(input: String) {
        require(input.toInt() % LottoShop.LOTTO_PRICE == 0) {
            "로또 구매 금액으로는 1000원 단위로만 입력받을 수 있습니다."
        }
    }
}