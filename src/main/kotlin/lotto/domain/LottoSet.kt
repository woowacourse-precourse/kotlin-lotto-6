package lotto.domain

class LottoSet {

    val lottoSet = mutableListOf<Lotto>()

    fun addLotto(lotto: Lotto) {
        lottoSet.add(lotto)
    }
}