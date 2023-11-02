package lotto.domain

class LottoSet {

    private val lottoSet = mutableListOf<Lotto>()

    fun addLotto(lotto: Lotto) {
        lottoSet.add(lotto)
    }

    fun countLotto(): Int {
        return lottoSet.size
    }
}