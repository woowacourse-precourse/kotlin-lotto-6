package lotto.domain

import lotto.data.LottoMatchInfo

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    fun matchingLotto(winningNumbers: List<Int>, bonusNumber: Int): LottoMatchInfo {
        return when (countMatchNumber(winningNumbers)) {
            6 -> LottoMatchInfo.MatchSix
            5 -> {
                if (isBonusNumberMatch(bonusNumber)) {
                    LottoMatchInfo.MatchFiveWithBonus
                } else {
                    LottoMatchInfo.MatchFive
                }
            }
            4 -> LottoMatchInfo.MatchFour
            3 -> LottoMatchInfo.MatchThree
            else -> LottoMatchInfo.MatchUnderThree
        }
    }

    private fun countMatchNumber(winningNumbers: List<Int>) = numbers.count { winningNumbers.contains(it) }

    private fun isBonusNumberMatch(bonusNumber: Int) = numbers.contains(bonusNumber)
}
