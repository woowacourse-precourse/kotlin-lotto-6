package lotto.domain

import lotto.model.LottoWinnerInfo

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    fun matchingLotto(winningNumbers: List<Int>, bonusNumber: Int): LottoWinnerInfo? {
        return when (countMatchNumber(winningNumbers)) {
            6 -> LottoWinnerInfo.MatchSix
            5 -> {
                if (isBonusNumberMatch(bonusNumber)) {
                    LottoWinnerInfo.MatchFiveWithBonus
                } else {
                    LottoWinnerInfo.MatchFive
                }
            }
            4 -> LottoWinnerInfo.MatchFour
            3 -> LottoWinnerInfo.MatchThree
            else -> null
        }
    }

    private fun countMatchNumber(winningNumbers: List<Int>) = numbers.count { winningNumbers.contains(it) }

    private fun isBonusNumberMatch(bonusNumber: Int) = numbers.contains(bonusNumber)
}
