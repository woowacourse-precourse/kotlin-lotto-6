package lotto.domain

class WinningCheck {
    fun numbersCheck(myLotto: List<Lotto>, winningNumber: List<Int>, bonusNumber: Int): List<Grade> {
        val gradeList = mutableListOf<Grade>()
        for (lotto in myLotto) {
            val result = compareNumbers(lotto.getNumbers(), winningNumber, bonusNumber)
            gradeList.add(winCheck(result))
        }
        return gradeList
    }

    private fun compareNumbers(lotto: List<Int>, winningNumber: List<Int>, bonusNumber: Int): Pair<Int, Boolean> {
        val correct = winningNumber.count { it in lotto }
        val hasBonusNumber = bonusNumber in lotto
        return Pair(correct, hasBonusNumber)
    }

    private fun winCheck(lottoResult: Pair<Int, Boolean>): Grade {
        when (lottoResult.first) {
            Grade.FIRST.correct -> return Grade.FIRST
            Grade.FOURTH.correct -> return Grade.FOURTH
            Grade.FIFTH.correct -> return Grade.FIFTH
        }
        if (lottoResult.first == Grade.SECOND.correct && lottoResult.second) {
            return Grade.SECOND
        }
        if (lottoResult.first == Grade.THIRD.correct && !lottoResult.second) {
            return Grade.THIRD
        }
        return Grade.MISS
    }
}