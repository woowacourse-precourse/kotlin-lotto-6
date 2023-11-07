package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.errorMessageFormat
import lotto.model.Lotto.Companion.MAX_LOTTO_RANGE
import lotto.model.Lotto.Companion.MAX_LOTTO_SIZE

object InputView {
    private const val PURCHASE_MONEY_MESSAGE = "구입금액을 입력해 주세요."
    private const val WINNING_NUMBER_MESSAGE = "\n당첨 번호를 입력해 주세요."
    private const val BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요."
    private const val DELIMITER_COMMA = ","
    private const val ERROR_PURCHASE_DIVIDE_MESSAGE = "구입 금액은 1000으로 나누어 떨어지지 않습니다."
    private const val ERROR_NUMBER_MESSAGE = "입력값이 숫자가 아닙니다."
    private const val ERROR_PRIZE_RANGE_MESSAGE = "당첨 번호는 1~45입니다."
    private const val ERROR_PRIZE_REPEAT_MESSAGE = "당첨 번호에 중복이 있으면 안됩니다."
    private const val ERROR_BONUS_REPEAT_MESSAGE = "보너스 번호와 당첨 번호에 중복이 있으면 안됩니다."

    const val ERROR_PRIZE_SIZE_MESSAGE = "당첨 번호 길이는 6입니다."
    const val LOTTO_PRICE = 1000

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
        check(userMoney % LOTTO_PRICE == 0) {
            errorMessageFormat(ERROR_PURCHASE_DIVIDE_MESSAGE)
        }
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
        require(winningNumber > 0) {
            errorMessageFormat(ERROR_NUMBER_MESSAGE)
        }

        return winningNumber
    }

    private fun checkNumberRange(winningNumber: Int) {
        check(winningNumber <= MAX_LOTTO_RANGE) {
            errorMessageFormat(ERROR_PRIZE_RANGE_MESSAGE)
        }
    }

    private fun checkDuplicateNumber(winningNumbers: List<Int>) {
        check(winningNumbers.toSet().size == winningNumbers.size) {
            errorMessageFormat(ERROR_PRIZE_REPEAT_MESSAGE)
        }
    }

    private fun checkDuplicateNumbersAndBonusNumber(winningNumbers: List<Int>, bonusNumber: Int) {
        check(!winningNumbers.contains(bonusNumber)) {
            errorMessageFormat(ERROR_BONUS_REPEAT_MESSAGE)
        }
    }

    private fun checkNumbersSize(winningNumbers: List<Int>) {
        check(winningNumbers.size == MAX_LOTTO_SIZE) {
            errorMessageFormat(ERROR_PRIZE_SIZE_MESSAGE)
        }
    }
}