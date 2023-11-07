package lotto.domain.validator

import lotto.domain.validator.InputValidator.validateInputIsInt
import lotto.domain.validator.InputValidator.validateInputIsNotZero

object LottoManagerValidator {
    fun validateWinningNumbersInput(input: String) {
        val inputList = input.split(",")
            .map { it.trim() }
            .let {
                validateInputIsIntList(it)
                validateInputsAreNotZero(it)
            }
    }

    private fun validateInputIsIntList(inputList: List<String>) {
        inputList.map { input ->
            validateInputIsInt(input, message = "로또 당첨 번호는 1이상 45이하의 숫자만 입력하실 수 있습니다.")
        }
    }

    private fun validateInputsAreNotZero(inputList: List<String>) {
        inputList.map { input ->
            validateInputIsNotZero(input, message = "로또 당첨 번호는 0일 수 없습니다")
        }
    }
}