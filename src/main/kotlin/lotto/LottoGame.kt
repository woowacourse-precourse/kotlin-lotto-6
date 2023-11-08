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
        inputPurchaseCost()
        createRandomLotto()
        inputUserPickNumbersAndBonus()
        getLottoWinning()
    }

    private fun inputPurchaseCost() {
        try {
            printer.printEnterPurchaseAnnouncement()
            val purchaseCostInput = Console.readLine()
            purchaseNumber = controller.purchaseLotto(purchaseCostInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            inputPurchaseCost()
        }
    }

    private fun createRandomLotto() {
        try {
            printer.printBuyNPiecesAnnouncement(purchaseNumber)
            randomLottoNumbers = controller.createLottoRandomNumbers(purchaseNumber)
            printer.printRandomLottoNumbers(randomLottoNumbers)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            createRandomLotto()
        }
    }

    private fun inputUserPickNumbersAndBonus() {
        try {
            printer.printEnterUserPickNumbersAnnouncement()
            val userPickNumberInput = Console.readLine().trim()
            printer.printEnterBonusNumberAnnouncement()
            val bonusNumberInput = Console.readLine().trim()

            userWinningNumbers = controller.createUserWinningNumbers(userPickNumberInput, bonusNumberInput)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            inputUserPickNumbersAndBonus()
        }
    }

    private fun getLottoWinning() {
        try {
            val winCount = controller.checkWinningDetails(randomLottoNumbers, userWinningNumbers)
            val winTypes = controller.checkLottoWinType(winCount)
            val yieldResult = controller.checkYieldResult(winTypes)

            printer.printWinningStatisticsAnnouncement()
            printer.printCommaAnnouncement()
            printer.printWinningStatistics(winTypes, yieldResult)
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            execute()
        }
    }

}