package lotto

import camp.nextstep.edu.missionutils.Console

class Presenter(
    private val printer: Printer = Printer(), private val game: Game = Game()
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
            purchaseNumber = game.purchaseLotto(input)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            purchaseLottery()
        }
    }

    private fun createRandomLottery() {
        try {
            printer.printBuyNPiecesAnnouncement(purchaseNumber)
            randomLottoNumbers = game.createLotteryRandomNumber(purchaseNumber)
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
            userPickLottoNumbers = game.inputUserPickNumbers(userPickNumberInput)
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
            bonusNumber = game.inputBonusNumber(input = bonusNumberInput, userPickNumbers = userPickLottoNumbers)
            println()
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            inputBonusNumber()
        }
    }

    private fun getLotteryWinning() {
        try {
            val winCount = game.checkWinningDetails(randomLottoNumbers, userPickLottoNumbers, bonusNumber)
            val winTypes = game.checkLottoWinType(winCount)
            val yield = game.checkYieldResult(winTypes)

            printer.printWinningStatisticsAnnouncement()
            printer.printCommaAnnouncement()
            printer.printWinningStatistics(winTypes, yield)
        } catch (e: IllegalArgumentException) {
            println(e.localizedMessage)
            execute()
        }
    }

}