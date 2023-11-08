package lotto

import camp.nextstep.edu.missionutils.Console

class InputManagement {
    var lottoNumbers = mutableListOf<Int>()
    var bonusNumber: Int = 0

    fun inputBonusNumbers(): Int {
        println(LottoResource.BONUS_NUMBER_INPUT_MESSAGE)
        val inputNumber = Console.readLine()
        bonusNumber = validateNumber(inputNumber)
        validateBonusNumberIsDuplicateWithLottoNumbers()
        return bonusNumber
    }

    fun inputLottoNumbers() {
        lottoNumbers.clear()
        println(LottoResource.LOTTO_NUMBER_INPUT_MESSAGE)
        val inputNumbers = Console.readLine()
        putValidNumberIntoLottoNumbers(inputNumbers)
    }

    private fun putValidNumberIntoLottoNumbers(inputNumbers: String) {
        val numbers = inputNumbers.split(",")
        numbers.forEach {
            val number = validateNumber(it)
            lottoNumbers.add(number)
        }
    }

    fun validateNumber(number: String): Int {
        require(number.toIntOrNull() != null) {
            Error.printErrorMessage(Error.LOTTO_NUMBER_TYPE_IS_NOT_INT)
        }
        val currentNumber = number.toInt()
        require(currentNumber in LottoResource.MIN_LOTTO_NUMBER..LottoResource.MAX_LOTTO_NUMBER) {
            Error.printErrorMessage(Error.LOTTO_NUMBER_IS_OUT_OF_RANGE)
        }
        return currentNumber
    }

    private fun validateBonusNumberIsDuplicateWithLottoNumbers() {
        lottoNumbers.forEach {
            require(it != bonusNumber) {
                Error.printErrorMessage(Error.BONUS_NUMBER_CANT_EQUAL_LOTTO_NUMBER)
            }
        }
    }
}