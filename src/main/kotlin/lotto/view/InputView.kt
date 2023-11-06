package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.DIVIDE_MONEY_NUMBER
import lotto.MAX_LOTTO_RANGE
import lotto.MAX_LOTTO_SIZE

object InputView {
    private const val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
    private const val DELIMITER_COMMA = ","

    fun getPurchaseMoney(): Int {
        println(PURCHASE_MONEY_MESSAGE)
        val inputPurchaseMoney = Console.readLine()
        return checkPurchaseMoney(inputPurchaseMoney)
    }

    private fun checkPurchaseMoney(inputPurchaseMoney: String): Int {
        val purchaseMoneyNum = checkPositiveInteger(inputPurchaseMoney)
        checkDivideMoney(purchaseMoneyNum)
        return purchaseMoneyNum
    }

    private fun checkDivideMoney(userMoney: Int) {
        require(userMoney % DIVIDE_MONEY_NUMBER == 0)
    }

    fun getWinningNumbers(): List<Int> {
        println(WINNING_NUMBER_MESSAGE)

        val inputWinningNumbers = Console.readLine().split(DELIMITER_COMMA)
        val winningNumbers = inputWinningNumbers.map {
            checkPositiveInteger(it)
        }
        winningNumbers.forEach {
            checkNumberRange(it)
        }

        checkDuplicateNumber(winningNumbers)
        checkNumbersSize(winningNumbers)

        return winningNumbers
    }

    fun getBonusNumber(winningNumbers: List<Int>): Int {
        println(BONUS_NUMBER_MESSAGE)
        val bonusNumber = checkPositiveInteger(Console.readLine())
        checkNumberRange(bonusNumber)
        checkDuplicateNumbersAndBonusNumber(winningNumbers, bonusNumber)

        return bonusNumber
    }

    private fun checkPositiveInteger(inputWinningNumber: String): Int {
        val winningNumber = inputWinningNumber.toIntOrNull() ?: 0
        require(winningNumber > 0)

        return winningNumber
    }

    private fun checkNumberRange(winningNumber: Int) {
        require(winningNumber <= MAX_LOTTO_RANGE)
    }

    private fun checkDuplicateNumber(winningNumbers: List<Int>) {
        require(winningNumbers.toSet().size == winningNumbers.size)
    }

    private fun checkDuplicateNumbersAndBonusNumber(winningNumbers: List<Int>, bonusNumber: Int) {
        require(!winningNumbers.contains(bonusNumber))
    }

    private fun checkNumbersSize(winningNumbers: List<Int>) {
        require(winningNumbers.size == MAX_LOTTO_SIZE)
    }
}