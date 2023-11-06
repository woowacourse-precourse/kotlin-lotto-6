package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요."

    fun getPurchaseMoney(): Int {
        println(PURCHASE_MONEY_MESSAGE)
        val inputPurchaseMoney = Console.readLine()
        return checkPurchaseMoney(inputPurchaseMoney)
    }

    private fun checkPurchaseMoney(inputPurchaseMoney: String): Int {
        val purchaseMoneyNum = checkNumber(inputPurchaseMoney)
        checkDivideMoney(purchaseMoneyNum)
        return purchaseMoneyNum
    }

    private fun checkNumber(purchaseMoney: String): Int {
        val purchaseMoneyNum = purchaseMoney.toIntOrNull() ?: 0
        require(purchaseMoneyNum > 0)
        return purchaseMoneyNum
    }

    private fun checkDivideMoney(userMoney: Int) {
        require(userMoney % 1000 != 0)
    }

    fun getWinningNumbers(): List<Int> {
        println("\n$WINNING_NUMBER_MESSAGE")

        val inputWinningNumbers = Console.readLine().split(",")
        val winningNumbers = inputWinningNumbers.map {
            checkPositiveInteger(it)
        }

        checkDuplicateNumber(winningNumbers)
        checkNumbersSize(winningNumbers)

        return winningNumbers
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println("\n$BONUS_NUMBER_MESSAGE")
        val bonusNumber = checkPositiveInteger(Console.readLine())
        checkDuplicateNumbersAndBonusNumber(winningNumbers, bonusNumber)

        return bonusNumber
    }

    private fun checkPositiveInteger(inputWinningNumber: String): Int {
        val winningNumber = inputWinningNumber.toIntOrNull() ?: 0
        require(winningNumber > 0)
        checkNumberRange(winningNumber)
        return winningNumber
    }

    private fun checkNumberRange(winningNumber: Int) {
        require(winningNumber <= 45)
    }

    private fun checkDuplicateNumber(winningNumbers: List<Int>) {
        require(winningNumbers.toSet().size == winningNumbers.size)
    }

    private fun checkDuplicateNumbersAndBonusNumber(winningNumbers: List<Int>, bonusNumber: Int) {
        require(!winningNumbers.contains(bonusNumber))
    }

    private fun checkNumbersSize(winningNumbers: List<Int>) {
        require(winningNumbers.size == 6)
    }
}