package lotto.domain.validator

import lotto.domain.LottoShop

class LottoShopValidator {

    fun validatePurchaseLottoInput(input : String){
        requireNotNull(input.toIntOrNull()){
            "로또 구매 금액은 1000원 단위 정수형만 입력받을 수 있습니다."
        }
        require(input.toInt() != 0){
            "로또 구매 금액으로는 0원 은 입력하실 수 없습니다."
        }
        require(input.toInt() % LottoShop.LOTTO_PRICE == 0){
            "로또 구매 금액으로는 1000원 단위로만 입력받을 수 있습니다."
        }
    }
}