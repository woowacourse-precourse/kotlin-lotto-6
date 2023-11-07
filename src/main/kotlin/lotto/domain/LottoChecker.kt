package lotto.domain

import lotto.Constants.LOTTO_COUNT

class LottoChecker(
    private val winNumber: Lotto,
    private val bonusNumber: Int,
) {

    private fun howMuchNumbersAreCorrect(userNumber: Lotto) = (userNumber intersect winNumber).size
    fun checkLotto(userNumber: Lotto): Position {
        val resultNum = howMuchNumbersAreCorrect(userNumber)
        return when {
            resultNum == LOTTO_COUNT -> Position.First
            resultNum == LOTTO_COUNT - 1 && userNumber.contains(bonusNumber) -> Position.Second
            resultNum == LOTTO_COUNT - 1 -> Position.Third
            resultNum == LOTTO_COUNT - 2 -> Position.Fourth
            resultNum == LOTTO_COUNT - 3 -> Position.Fifth
            else -> Position.NoLuck
        }
    }
}
