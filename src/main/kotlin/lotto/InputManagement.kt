package lotto

import camp.nextstep.edu.missionutils.Console

class InputManagement {
    var lottoNumbers = mutableListOf<Int>()

    fun inputLottoNumbers(): List<Int> {
        var isValidLottoNumber = false
        while (isValidLottoNumber) {
            println(LOTTO_NUMBER_INPUT_MESSAGE)
            val inputNumbers = Console.readLine()
            isValidLottoNumber = validateNumbers(inputNumbers)
        }
        return lottoNumbers
    }

    private fun putValidNumberIntoLottoNumbers(numbers: List<String>) {
        numbers.forEach {
            lottoNumbers.add(it.toInt())
        }
    }

    private fun validateNumbers(inputNumbers: String): Boolean {
        val numbers = inputNumbers.split(",")
        numbers.forEach {
            require(it.toIntOrNull() == null) {
                printErrorMessage(ERROR_LOTTO_NUMBER_TYPE_IS_NOT_INT)
                return false
            }
            val currentNumber = it.toInt()
            require(currentNumber < MIN_LOTTO_NUMBER || currentNumber > MAX_LOTTO_NUMBER) {
                printErrorMessage(ERROR_LOTTO_NUMBER_IS_OUT_OF_RANGE)
                return false
            }
        }
        putValidNumberIntoLottoNumbers(numbers)
        return true
    }

    private fun printErrorMessage(msg: String) {
        println(ERROR_MESSAGE_HEADER + msg)
    }
}