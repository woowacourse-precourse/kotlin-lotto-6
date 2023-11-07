package lotto.domain

import camp.nextstep.edu.missionutils.Console

class WinningNumber {
    private lateinit var winningNumbers: List<Int>
    private var bonusNumber: Int = -1

    fun decideWinningNumbers() {
        println("\n당첨 번호를 입력해 주세요.")
        winningNumbers = validateNumbers()
    }

    fun getWinningNumbers(): List<Int> {
        if (!::winningNumbers.isInitialized) {
            throw UninitializedPropertyAccessException("당첨 번호들이 결정되지 않았습니다.")
        }
        return winningNumbers
    }

    fun decideBonusNumber() {
        println("\n보너스 번호를 입력해 주세요.")
        bonusNumber = validateBonus()
    }

    fun getBonusNumber(): Int {
        if (bonusNumber == -1) {
            throw UninitializedPropertyAccessException("보너스 번호가 결정되지 않았습니다.")
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
                printErrorMessage(e.message ?: "[ERROR] Invalid input")
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
                printErrorMessage(e.message ?: "[ERROR] Invalid input")
            }
        }
    }

    private fun printErrorMessage(message: String) {
        println(message)
    }
}