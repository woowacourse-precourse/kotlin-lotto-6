package lotto.domain

import camp.nextstep.edu.missionutils.Console

class WinningNumber {
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber: Int = -1

    fun decideWinningNumbers() {
        println(INPUT_WINNING_NUMBERS)
        winningNumbers = validateNumbers()
    }

    fun getWinningNumbers(): List<Int> {
        if (!::winningNumbers.isInitialized) {
            throw UninitializedPropertyAccessException(INPUT_WINNING_NUMBERS_ERROR)
        }
        return winningNumbers
    }

    fun decideBonusNumber() {
        println(INPUT_BONUS_NUMBER)
        bonusNumber = validateBonus()
    }

    fun getBonusNumber(): Int {
        if (bonusNumber == -1) {
            throw UninitializedPropertyAccessException(INPUT_BONUS_NUMBER_ERROR)
        }
        return bonusNumber
    }

    private fun validateNumbers(): List<Int> {
        while (true) {
            try {
                val enterNumbers = Console.readLine().split(',').map { it.toIntOrNull() }
                require(enterNumbers.all { it != null }) { ValidatorNumbers.INVALID_FORMAT.message }
                require(enterNumbers.size == 6) { ValidatorNumbers.INVALID_SIZE.message }
                require(enterNumbers.all { it in 1..45 }) { ValidatorNumbers.INVALID_RANGE.message }
                require(enterNumbers.distinct().size == enterNumbers.size) { ValidatorNumbers.INVALID_DUPLICATE.message }

                return enterNumbers.map { it!! }

            } catch (e: IllegalArgumentException) {
                printErrorMessage(e.message ?: DEFAULT_ERROR)
            }
        }
    }

    private fun validateBonus(): Int {
        while (true) {
            try {
                val enterNumber = Console.readLine().toIntOrNull()
                require(enterNumber != null) { ValidatorBonus.INVALID_FORMAT.message }
                require(enterNumber in 1..45) { ValidatorBonus.INVALID_RANGE.message }
                require(enterNumber !in winningNumbers) { ValidatorBonus.INVALID_DUPLICATE.message }

                return enterNumber
            } catch (e: IllegalArgumentException) {
                printErrorMessage(e.message ?: DEFAULT_ERROR)
            }
        }
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }

    companion object{
        private const val INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
        private const val INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
        private const val INPUT_WINNING_NUMBERS_ERROR = "당첨 번호들이 결정되지 않았습니다."
        private const val INPUT_BONUS_NUMBER_ERROR = "보너스 번호가 결정되지 않았습니다."
        private const val DEFAULT_ERROR = "[ERROR] Invalid input"
    }
}