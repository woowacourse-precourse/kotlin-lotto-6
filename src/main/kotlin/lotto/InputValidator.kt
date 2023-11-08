package lotto

import lotto.exception.UnvalidCostException
import lotto.exception.UnvalidLottoNumberCountException
import lotto.exception.UnvalidLottoNumberException
import lotto.utility.Utils

class InputValidator {
    fun checkStringHasNonDigits(string: String) {
        val regex = Regex("[^0-9]")
        if (regex.containsMatchIn(string))
            throw NumberFormatException()
    }

    fun checkLottoNumberCount(string: String) {
        val lottoList = Utils.parseWithComma(string)

        if (lottoList.size != LOTTO_NUMBER_COUNT)
            throw UnvalidLottoNumberCountException()
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
}