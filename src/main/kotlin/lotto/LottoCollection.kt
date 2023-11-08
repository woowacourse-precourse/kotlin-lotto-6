package lotto

class LottoCollection {
    val lottoCollection: MutableList<Lotto> = mutableListOf()

    fun putLotto(lotto: Lotto) {
        lottoCollection.add(lotto)
    }

    fun collectionSize(): Int {
        return lottoCollection.size
    }

    fun checkWin(winNumbers: List<Int>, plusNumber: Int):List<Int> {
        val winRankList: MutableList<Int> = mutableListOf()
        for (lotto in lottoCollection) {
            winRankList.add(lotto.checkWin(winNumbers,plusNumber))
        }
        return winRankList
    }
}