package lotto.domain

class LottoSet {

    private val lottoSetList = mutableListOf<Lotto>()

    fun addLotto(lotto: Lotto) {
        lottoSetList.add(lotto)
    }

    fun countLotto(): Int {
        return lottoSetList.size
    }

    fun getLottoSet(): MutableList<Lotto> {
        return lottoSetList
    }
}