package lotto

import lotto.Constants.LOTTO_BONUS_COUNT

class LottoChecker(
    private val winNumber: Lotto,
    private val bonusNumber: Int,
) {

    private fun howMuchNumbersAreCorrect(userNumber: Lotto) = (userNumber intersect winNumber).size
    fun checkLotto(userNumber: Lotto): Position {
        val resultNum = howMuchNumbersAreCorrect(userNumber)
        return when {
            resultNum == LOTTO_BONUS_COUNT -> Position.First
            resultNum == LOTTO_BONUS_COUNT - 1 && userNumber.contains(bonusNumber) -> Position.Second
            resultNum == LOTTO_BONUS_COUNT - 1 -> Position.Third
            resultNum == LOTTO_BONUS_COUNT - 2 -> Position.Fourth
            resultNum == LOTTO_BONUS_COUNT - 3 -> Position.Fifth
            else -> Position.NoLuck
        }
    }
}
