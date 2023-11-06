package lotto.domain

import lotto.model.LottoResult
import lotto.model.MatchCount

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6)
        require(numbers.distinct().size == 6)
    }

    fun matchingLotto(winningNumbers: List<Int>, bonusNumber: Int) {
        when (matchCount(winningNumbers)) {
            MatchCount.Six -> LottoResult.MatchSix.value++
            MatchCount.Five -> if (isBonusNumberMatch(bonusNumber)) {
                LottoResult.MatchFiveWithBonus.value++
            } else {
                LottoResult.MatchFive.value++
            }
            MatchCount.Four -> LottoResult.MatchFour.value
            MatchCount.Three -> LottoResult.MatchThree.value++
            MatchCount.Remain -> return
        }
    }

    private fun matchCount(winningNumbers: List<Int>): MatchCount {
        val count = numbers.count { winningNumbers.contains(it) }
        return MatchCount.entries.find { it.value.contains(count) } ?: MatchCount.Remain
    }

    private fun isBonusNumberMatch(bonusNumber: Int) = numbers.contains(bonusNumber)
}
