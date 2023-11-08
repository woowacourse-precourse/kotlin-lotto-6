package lotto

import camp.nextstep.edu.missionutils.Randoms
import camp.nextstep.edu.missionutils.Console

class LottoGame() {
    fun start() {
            val lottoCount = purchaseSequence()
            val lottos = generateLottos(lottoCount)
            val winningNumbers = getWinnningNumberSequence()
            val bonusNumber = getBonusNumberSequence(winningNumbers)

            LottoResult(lottos, winningNumbers, bonusNumber)
    }

    private fun purchaseSequence(): Int {
        val purchaseAmount = getPurchaseAmount()
        val lottoCount = purchaseAmount.toInt() / Constants.LOTTO_PRIZE

        PrintText.printMessage(Constants.PRINT_COUNT_NUMBER_MESSAGE, lottoCount)
        return lottoCount
    }

    private fun generateUniqueLotto(): Lotto {
        var lotto: Lotto? = null
        while (lotto == null) {
            try {
                val numbers = Randoms.pickUniqueNumbersInRange(Constants.MIN_NUMBER,
                    Constants.MAX_NUMBER,
                    Constants.LOTTO_SIZE)
                lotto = Lotto(numbers)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
        return lotto
    }

    private fun generateLottos(count: Int): List<Lotto> {
        val lottoList = mutableListOf<Lotto>()
        repeat(count) {
            val lotto = generateUniqueLotto()
            lottoList.add(lotto)
            println(lotto)
        }
        println("")
        return lottoList
    }

    private fun getPurchaseAmount(): String {
        var userInput = ""
        while (true) {
            PrintText.printMessage(Constants.GET_PURCHASE_AMOUNT_MESSAGE, 0)
            userInput = Console.readLine()
            try {
                InputValidator.validatePurchaseAmount(userInput)
                println("")
                break
            }
            catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
        return userInput
    }

    private fun getWinnningNumberSequence(): List<Int> {
        return getWinnningNumber().split(",").map{ it.trim().toInt() }
    }
    private fun getWinnningNumber(): String {
        var userInput = ""

        while (true) {
            PrintText.printMessage(Constants.GET_WINNING_NUMBER_MESSAGE, 0)
            userInput = Console.readLine()
            try {
                InputValidator.validateWinningNumber(userInput)
                println("")
                break
            }
            catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
        return userInput
    }

    private fun getBonusNumberSequence(winningNumbers: List<Int>): Int {
        return getBonusNumber(winningNumbers).toInt()
    }
    private fun getBonusNumber(winningNumbers: List<Int>) : String {
        var userInput = ""

        while (true) {
            PrintText.printMessage(Constants.GET_BONUS_NUMBER_MESSAGE, 0)
            userInput = Console.readLine()
            try {
                InputValidator.validateBonusNumber(userInput, winningNumbers)
                println("")
                break
            }
            catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
        return userInput
    }
}