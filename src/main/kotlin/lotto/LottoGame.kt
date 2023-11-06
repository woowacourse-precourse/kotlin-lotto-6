package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    private val purchaseAmount = Console.readLine().toInt()
    fun start() {
        require(purchaseAmount % 1000 == 0) {"[ERROR]"}
        val lottoCount = purchaseAmount / 1000
        var lottos = generateLottos(lottoCount)
    }

    private fun generateLottos(count: Int) :List<Lotto>{
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
}