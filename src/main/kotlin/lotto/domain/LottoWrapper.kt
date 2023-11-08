package lotto.domain

class LottoWrapper {
    private val lottoWrapper = mutableListOf<Lotto>()

    fun add(lotto: Lotto) {
        lottoWrapper.add(lotto)
    }

    fun get(index: Int): Lotto {
        return lottoWrapper[index]
    }

    fun size(): Int {
        return lottoWrapper.size
    }
}