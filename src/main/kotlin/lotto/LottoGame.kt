package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    fun start() {
//        println("구입 금액을 입력해 주세요.")
//        val purchaseAmount = getPurchaseAmount()
//        require(purchaseAmount % 1000 == 0) {"[ERROR]"}
//        val lottoCount = purchaseAmount / 1000
//        println("${lottoCount}개를 구매했습니다.")
//        var lottos = generateLottos(lottoCount)
//        for (lotto in lottos) {
//            println(lotto)
//        }
//        println("당첨 번호를 입력해 주세요.")
//        val winningNumber = getWinnningNumber()
//        println("보너스 번호를 입력해 주세요.")
//        val bonusNumber = getBonusNumber()
//        println("당첨 통계")
    }

    private fun generateLottos(count: Int) :List<Lotto>{
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
    private fun getPurchaseAmount(): Int {
        return Console.readLine().toInt()
    }

    private fun getWinnningNumber(): List<String> {
        return Console.readLine().split(",")
    }

    private fun getBonusNumber() : Int {
        return Console.readLine().toInt()
    }

}