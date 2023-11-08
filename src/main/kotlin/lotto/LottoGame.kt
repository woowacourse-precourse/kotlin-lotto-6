package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    fun start() {
            val lottoCount = purchaseSequence()
            val lottos = generateLottos(lottoCount)
            val winningNumbers = getWinnningNumberSequence()
            val bonusNumber = getBonusNumberSequence()

            LottoResult(lottos, winningNumbers, bonusNumber)
    }

    private fun purchaseSequence(): Int {
        val purchaseAmount = getPurchaseAmount()
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
        var userInput = ""
        while (true) {
            PrintText.printMessage("GetPurchaseAmount", 0)
            userInput = Console.readLine()
            try {
                InputValidator.validatePurchaseAmount(userInput)
                break
            }
            catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
        return userInput
    }

    private fun getWinnningNumberSequence(): List<Int> {
        val winningNumber = getWinnningNumber()
        return winningNumber.split(",").map{ it.trim().toInt() }
    }
    private fun getWinnningNumber(): String {
        var userInput = ""
        while (true) {
            PrintText.printMessage("GetWinningNumber", 0)
            userInput = Console.readLine()
            try {
                InputValidator.validateWinningNumber(userInput)
                break
            }
            catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
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