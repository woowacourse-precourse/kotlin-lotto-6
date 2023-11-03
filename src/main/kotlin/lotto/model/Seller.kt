package lotto.model

import lotto.util.NumberGenerator

class Seller {
    fun sellLotto(amount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE
        val lottoPapers = mutableListOf<Lotto>()
        repeat(count) {
            lottoPapers.add(Lotto(NumberGenerator().generateNumbers()))
        }
        return lottoPapers
    }

    companion object {
        private const val LOTTO_PRICE = 1000
    }
}