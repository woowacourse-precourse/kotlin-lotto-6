package lotto.domain

import lotto.model.Lotto
import lotto.model.Prize
import lotto.utils.Constants
import lotto.utils.Constants.FIVE
import lotto.utils.Constants.FOUR
import lotto.utils.Constants.INIT_ZERO
import lotto.utils.Constants.SIX
import lotto.utils.Constants.THREE

class LottoRanks {
    fun checkMatchingNumbers(answerLottoNumbers: List<Int>, userWinningNumbers: List<Int>): Int {
        var matchedNumbers = INIT_ZERO
        userWinningNumbers.forEach {
            if (it in answerLottoNumbers) {
                matchedNumbers++
            }
        }
        return matchedNumbers
    }

    fun bonusMatched(bonusNumber: Int, answerLottoNumbers: List<Int>): Boolean {
        return answerLottoNumbers.contains(bonusNumber)
    }
}