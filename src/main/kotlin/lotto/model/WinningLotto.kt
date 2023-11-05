package lotto.model


import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Exception

class WinningLotto {

    private var _luckyNumbers = listOf<Int>()
    val luckyNumbers get() = _luckyNumbers
    private var _bonusNumber = 0
    val bonusNumber get() = _bonusNumber

    fun setLuckyNumbers(luckyNumbers : List<Int>) {
        Exception.validateInputLuckyNumber(luckyNumbers)
        _luckyNumbers = luckyNumbers
    }

    fun setBonusNumber(bonusNumber : Int){
        Exception.validateInputBonusNumber(bonusNumber)
        require(!luckyNumbers.contains(bonusNumber)) { INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE}
        _bonusNumber = bonusNumber
    }
}