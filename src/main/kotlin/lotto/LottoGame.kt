package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    fun start() {
        val lottoCount = purchaseSequence()
        var lottos = generateLottos(lottoCount)
        val winningNumbers = getWinnningNumberSequence()
        val bonusNumber = getBonusNumberSequence()

        val lottoResult = LottoResult(lottos, winningNumbers, bonusNumber)
    }

    private fun purchaseSequence(): Int{
        PrintText.printMessage("GetPurchaseAmount", 0)
        val purchaseAmount = getPurchaseAmount()
        InputValidator.validatePurchaseAmount(purchaseAmount)
        val lottoCount = purchaseAmount.toInt() / 1000
        PrintText.printMessage("PrintCountNumber", lottoCount)
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
        PrintText.printMessage("GetWinningNumber", 0)
        val winningNumber = getWinnningNumber()
        return winningNumber.split(",").map{ it.trim().toInt() }
    }
    private fun getWinnningNumber(): String {
        val userInput = Console.readLine()
        InputValidator.validateWinningNumber(userInput)
        return userInput
    }

    private fun getBonusNumberSequence(): Int {
        PrintText.printMessage("GetBonusNumber", 0)
        return getBonusNumber().toInt()
    }
    private fun getBonusNumber() : String {
        val userInput = Console.readLine()
        InputValidator.validateBonusNumber(userInput)
        return userInput
    }

}