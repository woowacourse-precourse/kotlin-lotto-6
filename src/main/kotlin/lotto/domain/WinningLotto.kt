package lotto.domain


import lotto.util.Constant.INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE
import lotto.util.Exception

class WinningLotto(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    init {
        Exception.validateInputWinningNumber(winningNumbers)
        Exception.validateInputBonusNumber(bonusNumber)
        require(!winningNumbers.contains(bonusNumber)) { INPUT_BONUS_NUMBER_OVERLAP_ERROR_MESSAGE }
    }

    fun getWinningNumbers() = winningNumbers
    fun getBonusNumber() = bonusNumber
}