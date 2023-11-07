package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    fun start() {
        val lottoCount = purchaseSequence()
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

    private fun printMessage(type: String, count: Int) {
        when(type) {
            "GetPurchaseAmount" -> println("구입 금액을 입력해 주세요.")
            "PrintCountNumber" -> println("${count}개를 구매했습니다.")
            "GetWinningNumber" -> println("당첨 번호를 입력해 주세요.")
            "GetBonusNumber" -> println("보너스 번호를 입력해 주세요.")
            "PrintWinningStatistics" -> println("당첨 통계")
            else -> println("ERROR")
        }
    }
    private fun purchaseSequence(): Int{
        printMessage("GetPurchaseAmount", 0)
        val purchaseAmount = getPurchaseAmount()
        InputValidator.validatePurchaseAmount(purchaseAmount)
        val lottoCount = purchaseAmount.toInt() / 1000
        printMessage("PrintCountNumber", lottoCount)
        return lottoCount
    }

    private fun generateLottos(count: Int) :List<Lotto>{
        return List(count) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }
    private fun getPurchaseAmount(): String {
        return Console.readLine()
    }

    private fun getWinnningNumber(): List<String> {
        return Console.readLine().split(",")
    }

    private fun getBonusNumber() : Int {
        return Console.readLine().toInt()
    }

}