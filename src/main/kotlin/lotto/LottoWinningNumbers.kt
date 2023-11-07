package lotto

import camp.nextstep.edu.missionutils.Console

class LottoWinningNumbers {
    var winningLotteryNumbers: List<Int> = emptyList()
    var bonusNumber = 0
    var validBonusNumber = false

    fun inputWinningNumbers(): List<Int> {
        var validWinningNumbers = false

        while (!validWinningNumbers) {
            println(MessageConstants.INPUT_WINNING_NUMBER)
            val input = Console.readLine()
            try {
                winningLotteryNumbers = input.split(',').map { it.trim().toInt() }
                Lotto(winningLotteryNumbers)
                validWinningNumbers = true
            } catch (e: NumberFormatException) {
                println(MessageConstants.ERROR_NOT_ALL_NUMBERS)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return winningLotteryNumbers
    }

    fun inputBonusNumber(): Int {
        while (!validBonusNumber) {
            println(MessageConstants.INPUT_BONUS_NUMBER)
            val bonusInput = Console.readLine()
            try {
                bonusNumber = bonusInput.trim().toInt()
                //validateBonusNumber()
                BonusNumber(bonusNumber, winningLotteryNumbers)
                validBonusNumber = true
            } catch (e: NumberFormatException) {
                println(MessageConstants.BONUS_NUMBER_IS_NOT_A_NUMBER)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        return bonusNumber
    }

//    fun validateBonusNumber() {
//        if (bonusNumber < 1 || bonusNumber > 45) {
//            throw IllegalArgumentException(MessageConstants.ERROR_LESS_THAN_1_OR_MORE_THAN_45)
//        }
//        if (winningLotteryNumbers.contains(bonusNumber)) {
//            throw IllegalArgumentException(MessageConstants.DUPLICATE_WINNING_AND_BONUS_NUMBER)
//        }

//        validBonusNumber = true
//    }
}