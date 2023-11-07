package lotto.domain

import lotto.model.Lotto
import lotto.model.Winning

class WinningStatistics() {

    fun computeStatistics(
        lottoNumbers: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): HashMap<Winning, Int> {

        val reward = HashMap<Winning, Int>()

        lottoNumbers.forEach {
            var countMatch = compareLotto(it.issueNumbers(), winningNumbers)

            var match = Winning.makeRewardStatistics(countMatch,compareBonus(it.issueNumbers(),bonusNumber))
            reward[match] = reward.getOrDefault(match, 0) + 1
        }
        return reward
    }

    private fun compareLotto(lottoTicket: List<Int>, winningNumbers: List<Int>): Int {
        var countMatch = 0

        for (number in winningNumbers) {
            if (lottoTicket.contains(number)) {
                countMatch++
            }
        }
        return countMatch
    }

    private fun compareBonus(lottoTicket: List<Int>, bonusNumber: Int): Boolean {
        return lottoTicket.contains(bonusNumber)
    }

}