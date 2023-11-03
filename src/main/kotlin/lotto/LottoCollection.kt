package lotto

class LottoCollection {
    val lottoCollection: MutableList<Lotto> = mutableListOf()

    fun putLotto(lotto: Lotto) {
        lottoCollection.add(lotto)
    }
}