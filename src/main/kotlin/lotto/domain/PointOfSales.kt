package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto
import lotto.data.Stats
import lotto.data.WinningLotto

class PointOfSales(private val analyzer: Analyzer) : RetryStrategy() {

    fun issueLotto(quantity: Int): List<Lotto> {
        require(quantity > MIN_QUANTITY_EXCLUSIVE) {
            QUANTITY_SHOULD_BE_MORE_THEN_0
        }
        val tickets = mutableListOf<Lotto>()
        repeat(quantity) {
            tickets.add(Lotto(getRandomLottoNum()))
        }
        return tickets.toList()
    }

    fun checkResult(tickets: List<Lotto>): Stats {
        val winningLotto = getWinningLotto()

        return analyzer.getStats(tickets, winningLotto)
    }

    private fun getWinningLotto(): WinningLotto {
        val nums = doUntilSuccess { IO.getInstance().getWinningLottoNum() }
        val bonus = doUntilSuccess { IO.getInstance().getBonusNum(nums) }
        return executeWithFallback(
            primary = { WinningLotto(nums, bonus) },
            fallback = { getWinningLotto() },
        )
    }

    private fun getRandomLottoNum() =
        Randoms.pickUniqueNumbersInRange(Lotto.START_NUM, Lotto.END_NUM, Lotto.LENGTH_OF_NUM).sorted()

    companion object {
        const val QUANTITY_SHOULD_BE_MORE_THEN_0 = "[ERROR] 구매 수량은 1개 이상이어야 합니다."
        private const val MIN_QUANTITY_EXCLUSIVE = 0
    }
}