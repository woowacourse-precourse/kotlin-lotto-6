package lotto.domain.validator

import lotto.domain.validator.InputValidator.validateInputIsInt
import lotto.domain.validator.InputValidator.validateInputIsNotZero
import lotto.domain.validator.InputValidator.validateInputsInRange
import lotto.domain.validator.InputValidator.validateNumberInRange
import lotto.domain.validator.InputValidator.validateStringListHasUniqueElements

object LottoManagerValidator {
    fun validateWinningNumbersInput(input: String) {
        val inputList = input
            .split(",")
            .map { it.trim() }

        validateInputIsIntList(inputList)
        validateInputsAreNotZero(inputList)
        validateInputsInRange(inputList, "당첨 번호는 1이상 45이하의 숫자만 입력 하실 수 있습니다.")
        validateStringListHasUniqueElements(inputList, "당첨 번호는 중복된 숫자를 입력하실 수 없습니다.")
    }

    private fun validateInputIsIntList(inputList: List<String>) =
        inputList.map { input ->
            validateInputIsInt(input, message = "로또 당첨 번호는 1이상 45이하의 숫자만 입력하실 수 있습니다.")
        }

    private fun validateInputsAreNotZero(inputList: List<String>) =
        inputList.map { input ->
            validateInputIsNotZero(input, message = "로또 당첨 번호는 0일 수 없습니다.")
        }


    fun validateBonusNumberInput(input: String) {
        validateInputIsInt(input, "보너스 번호는 1이상 45이하의 숫자만 입력 하실 수 있습니다.")
        validateInputIsNotZero(input, "보너스 번호는 0일 수 없습니다.")
        validateNumberInRange(input.toInt(), "보너스 번호는 1이상 45이하의 숫자만 입력 하실 수 있습니다.")
    }

    fun validateNoDuplicateNumbers(winningNumbers: List<Int>, bonusNumberInput: String) =
        winningNumbers.forEach { winningNumber ->
            require(winningNumber != bonusNumberInput.toInt()) {
                "[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다."
            }
        }
}