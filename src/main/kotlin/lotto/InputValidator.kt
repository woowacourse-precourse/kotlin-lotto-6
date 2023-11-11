package lotto

import lotto.exception.*
import lotto.utility.Utils

class InputValidator {
    fun checkCostInput(string: String) {
        checkStringHasNonDigits(string)
        checkCostDevidedByUnit(string)
        checkNumberIsPositive(string)
    }

    fun checkLottoInput(string: String) {
        checkLottoNumberCount(string)
        checkListNumberIsInRange(string)
        checkDuplicatesLottoNumber(string)
    }

    fun checkBonusInput(string: String, lottoList: List<Int>) {
        checkStringHasNonDigits(string)
        checkNumberIsInRange(string)
        checkDuplicatesBonusNumber(string, lottoList)
    }

    fun checkDuplicatesLottoNumber(string: String) {
        val lottoList = Utils.parseWithComma(string)
        val distinctList = lottoList.distinct()

        if (lottoList.size != distinctList.size)
            throw DuplicatedNumberException()
    }

    fun checkDuplicatesBonusNumber(string: String, lottoList: List<Int>) {
        if (lottoList.contains(string.toInt()))
            throw DuplicatedNumberException()
    }

    fun checkStringHasNonDigits(string: String) {
        val regex = Regex("[^0-9]")
        if (regex.containsMatchIn(string))
            throw ContainsNotDigitException()
    }

    fun checkLottoNumberCount(string: String) {
        val lottoList = Utils.parseWithComma(string)

        if (lottoList.size != LOTTO_NUMBER_COUNT)
            throw UnvalidLottoNumberCountException()
    }

    fun checkListNumberIsInRange(string: String) {
        val lottoList = string.split(SEPARATOR)

        for (number in lottoList) {
            checkStringHasNonDigits(number)
            checkNumberIsInRange(number)
        }
    }

    fun checkNumberIsInRange(string: String) {
        val number = string.toInt()

        if (number !in 0..45)
            throw UnvalidLottoNumberException()
    }

    fun checkCostDevidedByUnit(string: String) {
        if (string.toInt() % COST_UNIT != 0)
            throw UnvalidCostException()
    }

    fun checkNumberIsPositive(string: String) {
        val number = string.toInt()

        if (number < 0)
            throw NotPositiveCostException()
    }
}