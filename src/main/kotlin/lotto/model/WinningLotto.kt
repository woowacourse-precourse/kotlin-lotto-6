package lotto.model


import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Exception

class WinningLotto(private val luckyNumbers: List<Int>, private val bonusNumber: Int) {

    init{
        Exception.validateInputLuckyNumber(luckyNumbers)
        Exception.validateInputBonusNumber(bonusNumber)
        require(!luckyNumbers.contains(bonusNumber)) { INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE}
    }

    fun getLuckyNumbers() = luckyNumbers
    fun getBonusNumber() = bonusNumber
}