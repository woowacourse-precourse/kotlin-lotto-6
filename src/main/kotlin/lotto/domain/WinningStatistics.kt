package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoRecord

class WinningStatistics() {

    fun computeStatisics(
        lottoNumbers: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<Int> {

        val reward = IntArray(5) {0}

        lottoNumbers.forEach {
            var countMatch = compareLotto(it.issueNumbers(), winningNumbers)

            when{
                countMatch == LottoRecord.FIRST.match -> reward[4]++
                countMatch == LottoRecord.SECOND.match && compareBonus(it.issueNumbers(),bonusNumber) -> reward[3]++
                countMatch == LottoRecord.THIRD.match -> reward[2]++
                countMatch == LottoRecord.FOURTH.match -> reward[1]++
                countMatch == LottoRecord.FIFTH.match -> reward[0]++


            }
        }
        return reward.toList()
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