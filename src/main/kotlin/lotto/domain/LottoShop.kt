package lotto.domain

import lotto.domain.validator.LottoShopValidator.validatePurchaseLottoInput

class LottoShop {
    private val lottoNumberGenerator: RandomNumberGenerator by lazy { RandomNumberGenerator() }

    fun purchaseLottos(input: String): List<Lotto> {
        validatePurchaseLottoInput(input)
        val purchasedLottoCount = input.toInt() / LOTTO_PRICE
        return createLottos(purchasedLottoCount)
    }

    private fun createLottos(purchasedLottoCount: Int): List<Lotto> {
        val lottos: MutableList<Lotto> = mutableListOf()

        repeat(purchasedLottoCount) {
            val createdLotto = createLotto()
            lottos.add(createdLotto)
        }

        return lottos.toList()
    }

    private fun createLotto(): Lotto {
        val lottoNumbers = lottoNumberGenerator.generateNumbers()
        return Lotto(lottoNumbers)
    }

    companion object {
        val LOTTO_PRICE = 1000
    }
}