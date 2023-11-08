package lotto

import camp.nextstep.edu.missionutils.Console

class LottoGame(
    private val printer: Printer = Printer(),
    private val controller: Controller = Controller(),
    private var purchaseNumber: Int = 0,
) {

    private lateinit var randomLottoNumbers: List<Lotto>
    private lateinit var userWinningNumbers: UserWinningNumbers

    fun execute() {
        purchaseLottery()
        createRandomLottery()
        inputUserPickNumbersAndBonus()
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

    private fun inputUserPickNumbersAndBonus() {
        try {
            printer.printEnterUserPickNumbersAnnouncement()
            val userPickNumberInput = Console.readLine().trim()
            printer.printEnterBonusNumberAnnouncement()
            val bonusNumberInput = Console.readLine().trim()

            userWinningNumbers = controller.createLottoWinningNumbers(userPickNumberInput, bonusNumberInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            inputUserPickNumbersAndBonus()
        }
    }

    private fun getLotteryWinning() {
        try {
            val winCount = controller.checkWinningDetails(randomLottoNumbers, userWinningNumbers)
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