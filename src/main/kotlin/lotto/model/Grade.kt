package lotto.model

class Grade {
    private val lottoGrade = mutableMapOf<String, Int>()
    init {
        lottoGrade[FIRST] = 0
        lottoGrade[SECOND] = 0
        lottoGrade[THIRD] = 0
        lottoGrade[FORTH] = 0
        lottoGrade[FIFTH] = 0
    }

    fun getLottoGradeResult(): MutableMap<String, Int> {
        return this.lottoGrade
    }

    fun decideGrade(lotto: Lotto, winningNumber: WinningNumber) {
        val numberCount = lotto.compareLottoNumber(winningNumber.getWinningNumbers())
        val bonusNumberResult = lotto.compareBonusNumber(winningNumber.getBonusNumber())
        when {
            numberCount == 6 || (numberCount == 5 && bonusNumberResult) -> countGrade(FIRST, this.lottoGrade)
            numberCount == 5 -> countGrade(SECOND, this.lottoGrade)
            numberCount == 4 && bonusNumberResult -> countGrade(THIRD, this.lottoGrade)
            numberCount == 4 || (numberCount == 3 && bonusNumberResult) -> countGrade(FORTH, this.lottoGrade)
            numberCount == 3 || (numberCount == 2 && bonusNumberResult) -> countGrade(FIFTH, this.lottoGrade)
        }
    }

    private fun countGrade(grade: String, result: MutableMap<String, Int>) {
        result[grade] = result[grade]!! + 1
    }

    companion object {
        private const val FIRST = "FIRST"
        private const val SECOND = "SECOND"
        private const val THIRD = "THIRD"
        private const val FORTH = "FORTH"
        private const val FIFTH = "FIFTH"
    }
}