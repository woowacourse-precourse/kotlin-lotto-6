package lotto

class LottoView {
    fun showGenerateLotto(lottoCollection: LottoCollection) {
        println("${lottoCollection.collectionSize()}개를 구매했습니다.")
        for (lotto in lottoCollection.lottoCollection) {
            println(lotto.amount())
        }
    }

    fun showLottoResult() {

    }
}