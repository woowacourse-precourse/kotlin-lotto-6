package lotto.domain

object LottoSet {

    private val lottoSetList = mutableListOf<Lotto>()

    fun addLotto(lotto: Lotto) {
        lottoSetList.add(lotto)
    }

    fun getLottoSet(): MutableList<Lotto> {
        return lottoSetList
    }
}