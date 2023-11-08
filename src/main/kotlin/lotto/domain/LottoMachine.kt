package lotto.domain

import camp.nextstep.edu.missionutils.Console
import lotto.util.Constants


class LottoMachine {

    fun inputWinningNumbers(): List<Int> {
        val winningNumbers = Console.readLine().split(",").map { it.toInt() }
        validateWinningNumbers(winningNumbers)
        return winningNumbers
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        val bonusNumber = Console.readLine()
        validateBonusNumber(bonusNumber, winningNumbers)
        return bonusNumber.toInt()
    }

    fun validateWinningNumbers(winningNumbers: List<Int>) {
        require(winningNumbers.all { it in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER }) {
            throw IllegalArgumentException(
                NUMBER_OUT_OF_RANGE
            )
        }
        require(winningNumbers.size == Constants.CNT_LOTTO_NUMBER) { throw IllegalArgumentException(NUMBER_COUNT_ERROR) }
        require(winningNumbers.toSet().size == Constants.CNT_LOTTO_NUMBER) {
            throw IllegalArgumentException(
                DUPLICATE_WINNING_NUMBER
            )
        }
    }

    fun validateBonusNumber(number: String, winningNumbers: List<Int>) {
        val bonusNumber = number.toIntOrNull() ?: throw IllegalArgumentException(INPUT_TYPE_ERROR)
        require(bonusNumber in Constants.MIN_LOTTO_NUMBER..Constants.MAX_LOTTO_NUMBER) {
            throw IllegalArgumentException(
                NUMBER_OUT_OF_RANGE
            )
        }
        require(bonusNumber !in winningNumbers) { throw IllegalArgumentException(DUPLICATE_BONUS_NUMBER) }
    }

    companion object {
        const val NUMBER_OUT_OF_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."
        const val NUMBER_COUNT_ERROR = "[ERROR] 당첨 번호 6개를 입력해야 합니다."
        const val DUPLICATE_WINNING_NUMBER = "[ERROR] 중복된 번호가 존재합니다."
        const val DUPLICATE_BONUS_NUMBER = "[ERROR] 보너스 번호가 당첨 번호와 중복됩니다."
        const val INPUT_TYPE_ERROR = "[ERROR] 숫자로 입력해야 합니다."
    }

}