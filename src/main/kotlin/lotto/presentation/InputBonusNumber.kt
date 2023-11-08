package lotto.presentation

import lotto.isLottoNumberInRange

class InputBonusNumber {
    companion object {
        fun validate(inputBonusNumber: String, winningNumber: List<Int>) {
            validateIsNumber(inputBonusNumber)

            val bonusNumber = inputBonusNumber.toInt()
            validateWinningNumbersInRange(bonusNumber)
            validateDuplicateWithWinningNumber(bonusNumber, winningNumber)
        }

        private fun validateIsNumber(inputBonusNumber: String) {
            inputBonusNumber.toIntOrNull() ?: throw IllegalArgumentException("보너스 번호는 숫자로 입력해야합니다")
        }

        private fun validateWinningNumbersInRange(bonusNumber: Int) {
            require(bonusNumber.isLottoNumberInRange()) {
                throw IllegalArgumentException("보너스 번호는 1~45 사이의 숫자로 입력해야합니다")
            }
        }

        private fun validateDuplicateWithWinningNumber(bonusNumber: Int, winningNumber: List<Int>) {
            require(!winningNumber.contains(bonusNumber)) {
                throw IllegalArgumentException("보너스 번호는 당첨 번호와 중복될 수 없습니다")
            }
        }
    }
}