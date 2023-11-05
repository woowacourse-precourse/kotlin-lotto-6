package lotto.domain

import camp.nextstep.edu.missionutils.Console

class WinningNumber {
    private lateinit var winningNumbers: List<Int>

    fun decideWinningNumbers() {
        println("당첨 번호를 입력해 주세요.")
        winningNumbers = validateNumbers()
    }

    fun getWinningNumbers(): List<Int> {
        if (!::winningNumbers.isInitialized) {
            throw UninitializedPropertyAccessException("Winning numbers have not been decided yet.")
        }
        return winningNumbers
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

    private fun printErrorMessage(message: String) {
        println(message)
    }
}