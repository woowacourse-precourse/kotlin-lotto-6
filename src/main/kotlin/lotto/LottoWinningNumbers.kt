package lotto

import camp.nextstep.edu.missionutils.Console

class LottoWinningNumbers {
    fun inputWinningNumbers(): List<Int> {
        var winningLotteryNumbers: List<Int> = emptyList()
        var validWinningNumbers = false

        while (!validWinningNumbers) {
            println(MessageConstants.INPUT_WINNING_NUMBER)
            val input = Console.readLine()
            try {
                winningLotteryNumbers = input.split(',').map { it.trim().toInt() }
                val lotto = Lotto(winningLotteryNumbers)
                validWinningNumbers = true
            } catch (e: NumberFormatException) {
                println(MessageConstants.ERROR_NOT_ALL_NUMBERS)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return winningLotteryNumbers
    }

    fun inputBonusNumber(winningLotteryNumbers: List<Int>): Int {
        var bonusNumber = 0
        var validBonusNumber = false

        while (!validBonusNumber) {
            println(MessageConstants.INPUT_BONUS_NUMBER)
            val bonusInput = Console.readLine()
            try {
                bonusNumber = bonusInput.trim().toInt()
                if (bonusNumber < 1 || bonusNumber > 45) {
                    throw IllegalArgumentException(MessageConstants.ERROR_LESS_THAN_1_OR_MORE_THAN_45)
                }
                if (winningLotteryNumbers.contains(bonusNumber)) {
                    throw IllegalArgumentException(MessageConstants.DUPLICATE_WINNING_AND_BONUS_NUMBER)
                }
                validBonusNumber = true
            } catch (e: NumberFormatException) {
                println(MessageConstants.BONUS_NUMBER_IS_NOT_A_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return bonusNumber
    }
}