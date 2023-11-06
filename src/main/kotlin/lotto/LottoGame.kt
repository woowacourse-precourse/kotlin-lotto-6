package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGame(private val purchaseAmount: Int) {
    private val lottos: List<Lotto>
    init {
        require(purchaseAmount % 1000 == 0) {"[ERROR]"}
        val lottoCount = purchaseAmount / 1000
        lottos = generateLottos(lottoCount)
    }

    private fun generateLottos(count: Int) :List<Lotto>{
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}