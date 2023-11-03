package lotto

class Seller {
    fun sellLotto(amount: Int): List<Lotto> {
        val count = amount / LOTTO_PRICE
        val lottoPapers = mutableListOf<Lotto>()
        repeat(count) {
            lottoPapers.add(Lotto(NumberGeneration().generateNumbers()))
        }
        return lottoPapers
    }

    companion object {
        const val LOTTO_PRICE = 1000
    }
}