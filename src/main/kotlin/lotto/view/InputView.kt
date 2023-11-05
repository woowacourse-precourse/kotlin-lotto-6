package lotto.view

import camp.nextstep.edu.missionutils.Console

object InputView {

    private const val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해 주세요."
    fun getPurchaseMoney(): Int {
        println(PURCHASE_MONEY_MESSAGE)
        val inputPurchaseMoney = Console.readLine()

        return inputPurchaseMoney.toInt()
    }

    fun getWinningNumber(): List<Int> {
        println("\n$WINNING_NUMBER_MESSAGE")

        val inputWinningNumbers = Console.readLine().split(",")
        val winningNumbers = mutableListOf<Int>()

        inputWinningNumbers.forEach {
            winningNumbers.add(checkPositiveInteger(it))
        }
        checkDuplicateNumber(winningNumbers)
        return winningNumbers
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
}