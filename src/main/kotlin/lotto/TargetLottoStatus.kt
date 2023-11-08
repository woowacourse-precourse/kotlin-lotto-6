package lotto

import camp.nextstep.edu.missionutils.Console

class TargetLottoStatus {
    var lottoNumbers = mutableListOf<Int>()
    var bonusNumber: Int = 0
    fun inputTargetLotto() {
        repeatUntilValidLottoNumber()
        repeatUntilValidBonusNumber()
    }
    fun repeatUntilValidLottoNumber() {
        var isValidLotto = false
        while (!isValidLotto) {
            isValidLotto = true
            try {
                inputLottoNumbers()
            } catch (e: IllegalArgumentException) {
                isValidLotto = false
            }
        }
    }
    fun repeatUntilValidBonusNumber() {
        var isValidBonus = false
        while (!isValidBonus) {
            isValidBonus = true
            try {
                inputBonusNumber()
            } catch (e: IllegalArgumentException) {
                isValidBonus = false
            }
        }
    }
    fun inputBonusNumber() {
        println(LottoResource.BONUS_NUMBER_INPUT_MESSAGE)
        val inputNumber = Console.readLine()
        println()
        bonusNumber = validateNumber(inputNumber)
        validateBonusNumberIsDuplicateWithLottoNumbers()
    }
    fun inputLottoNumbers() {
        lottoNumbers.clear()
        println(LottoResource.LOTTO_NUMBER_INPUT_MESSAGE)
        val inputNumbers = Console.readLine()
        println()
        putValidNumberIntoLottoNumbers(inputNumbers)
        Lotto(lottoNumbers)
    }
    fun putValidNumberIntoLottoNumbers(inputNumbers: String) {
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
    fun validateBonusNumberIsDuplicateWithLottoNumbers() {
        require(!lottoNumbers.contains(bonusNumber)) {
            Error.printErrorMessage(Error.BONUS_NUMBER_CANT_EQUAL_LOTTO_NUMBER)
        }
    }
}