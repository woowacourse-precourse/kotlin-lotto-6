package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    fun start() {
        val lottoCount = purchaseSequence()
        var lottos = generateLottos(lottoCount)
        val winningNumber = getWinnningNumberSequence()
        val bonusNumber = getBonusNumberSequence()
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
            val lotto = Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
            println(lotto)
            lotto
        }
    }

    private fun getPurchaseAmount(): String {
        return Console.readLine()
    }

    private fun getWinnningNumberSequence(): List<Int> {
        printMessage("GetWinningNumber", 0)
        val winningNumber = getWinnningNumber()
        return winningNumber.split(",").map{ it.trim().toInt() }
    }
    private fun getWinnningNumber(): String {
        val userInput = Console.readLine()
        InputValidator.validateWinningNumber(userInput)
        return userInput
    }

    private fun getBonusNumberSequence(): Int {
        printMessage("GetBonusNumber", 0)
        return getBonusNumber().toInt()
    }
    private fun getBonusNumber() : String {
        val userInput = Console.readLine()
        InputValidator.validateBonusNumber(userInput)
        return userInput
    }

}