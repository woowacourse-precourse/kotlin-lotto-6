package lotto

import camp.nextstep.edu.missionutils.Console

class LottoGame(
    private val printer: Printer = Printer(), private val controller: Controller = Controller()
) {
    private var purchaseNumber: Int = 0
    private lateinit var userPickLottoNumbers: List<Int>
    private lateinit var randomLottoNumbers: List<Lotto>
    private var bonusNumber: Int = 0

    fun execute() {
        purchaseLottery()
        createRandomLottery()
        inputUserPickNumbers()
        inputBonusNumber()
        getLotteryWinning()
    }

    private fun purchaseLottery() {
        try {
            printer.printEnterPurchaseAnnouncement()
            val input = Console.readLine()
            purchaseNumber = controller.purchaseLotto(input)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            purchaseLottery()
        }
    }

    private fun createRandomLottery() {
        try {
            printer.printBuyNPiecesAnnouncement(purchaseNumber)
            randomLottoNumbers = controller.createLotteryRandomNumber(purchaseNumber)
            printer.printRandomLottoNumber(randomLottoNumbers)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            createRandomLottery()
        }
    }

    private fun inputUserPickNumbers() {
        try {
            printer.printEnterUserPickNumbersAnnouncement()
            val userPickNumberInput = Console.readLine().trim()
            userPickLottoNumbers = controller.inputUserPickNumbers(userPickNumberInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            inputUserPickNumbers()
        }
    }

    private fun inputBonusNumber() {
        try {
            printer.printEnterBonusNumberAnnouncement()
            val bonusNumberInput = Console.readLine().trim()
            bonusNumber = controller.inputBonusNumber(input = bonusNumberInput, userPickNumbers = userPickLottoNumbers)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            inputBonusNumber()
        }
    }

    private fun getLotteryWinning() {
        try {
            val winCount = controller.checkWinningDetails(randomLottoNumbers, userPickLottoNumbers, bonusNumber)
            val winTypes = controller.checkLottoWinType(winCount)
            val yield = controller.checkYieldResult(winTypes)

            printer.printWinningStatisticsAnnouncement()
            printer.printCommaAnnouncement()
            printer.printWinningStatistics(winTypes, yield)
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            execute()
        }
    }

}