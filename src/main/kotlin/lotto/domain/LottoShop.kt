package lotto.domain

import lotto.domain.validator.LottoShopValidator

class LottoShop {

    private val lottoShopValidator = LottoShopValidator()

    fun purchaseLotto(input: String): List<Lotto> {
        lottoShopValidator.validatePurchaseLottoInput(input)

        val lottos: MutableList<Lotto> = mutableListOf()

        repeat(input.toInt() / LOTTO_PRICE) {
            lottos.add(Lotto(listOf(1, 2, 3, 4, 5, 6)))
        }

        return lottos.toList()
    }

    companion object {
        val LOTTO_PRICE = 1000
    }
}