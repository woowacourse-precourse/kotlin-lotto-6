package lotto.presentation

import lotto.isAllLottoNumberInRange
import lotto.isUnique

object InputWinningNumber {
    fun validate(inputWinningNumbers: String) {
        validateNumberCount(inputWinningNumbers)
        validateAllNumber(inputWinningNumbers)

        val winningNumbers = inputWinningNumbers.split(",").map(Integer::parseInt)
        validateWinningNumbersInRange(winningNumbers)
        validateUniqueWinningNumbers(winningNumbers)
    }

    private fun validateNumberCount(inputWinningNumbers: String) {
        require(inputWinningNumbers.split(",").size == 6) {
            throw IllegalArgumentException("당첨 번호는 6개를 입력해야합니다")
        }
    }

    private fun validateAllNumber(inputWinningNumbers: String) {
        inputWinningNumbers.split(",").forEach { num ->
            num.toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 모두 숫자로 입력해야합니다")
        }
    }

    private fun validateWinningNumbersInRange(winningNumbers: List<Int>) {
        require(winningNumbers.isAllLottoNumberInRange()) {
            throw IllegalArgumentException("당첨 번호는 1~45 사이의 숫자로 입력해야합니다")
        }
    }

    private fun validateUniqueWinningNumbers(winningNumbers: List<Int>) {
        require(winningNumbers.isUnique()) {
            throw IllegalArgumentException("당첨 번호는 중복될 수 없습니다")
        }
    }
}