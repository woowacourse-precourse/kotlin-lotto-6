package lotto.domain

import lotto.domain.validator.LottoShopValidator

class LottoShop {

    private val lottoShopValidator: LottoShopValidator by lazy { LottoShopValidator() }
    val lottoNumberGenerator: RandomNumberGenerator by lazy { RandomNumberGenerator() }

    fun purchaseLotto(input: String): List<Lotto> {
        lottoShopValidator.validatePurchaseLottoInput(input)

        val lottos: MutableList<Lotto> = mutableListOf()

        repeat(input.toInt() / LOTTO_PRICE) {
            val lottoNumbers = lottoNumberGenerator.generateNumber()
            lottos.add(Lotto(lottoNumbers))
        }

        return lottos.toList()
    }

    companion object {
        val LOTTO_PRICE = 1000
    }
}