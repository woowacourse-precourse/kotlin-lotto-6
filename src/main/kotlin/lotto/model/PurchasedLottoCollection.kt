package lotto.model

class PurchasedLottoCollection(private val lottoCount: Int, lottoList: List<Int>, bonusBall: Int) {
    private var purchasedLottos = mutableListOf<PurchasedLotto>()

    init {
        for (i in 0 ..< lottoCount) {
            purchasedLottos.add(PurchasedLotto(lottoList, bonusBall))
        }
    }
}