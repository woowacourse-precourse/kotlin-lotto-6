package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto
import lotto.data.WinningLotto

class PointOfSales : RetryUntilSuccess() {

    fun issueLotto(quantity: Int): List<Lotto> {
        require(quantity > 0) {
            QUANTITY_SHOULD_BE_MORE_THEN_0
        }
        val tickets = mutableListOf<Lotto>()
        repeat(quantity) {
            tickets.add(Lotto(getRandomLottoNum()))
        }
        return tickets.toList()
    }

    fun getQuotientAndRemainder(dividend: UInt, divisor: UInt): Pair<Int, Int> {
        val quotient = (dividend / divisor).toInt()
        val remainder = (dividend % divisor).toInt()

        return quotient to remainder
    }

    private fun getWinningLotto(): WinningLotto {
        val nums = doUntilSuccess { IO.getInstance().getWinningLottoNum() }
        val bonus = doUntilSuccess { IO.getInstance().getBonusNum(nums) }
        return executeOrFallback(
            primary = { WinningLotto(nums, bonus) },
            fallback = { getWinningLotto() },
        )
    }

    private fun getRandomLottoNum() =
        Randoms.pickUniqueNumbersInRange(Lotto.START_NUM, Lotto.END_NUM, Lotto.LENGTH_OF_NUM).sorted()

    companion object {
        const val QUANTITY_SHOULD_BE_MORE_THEN_0 = "[ERROR] 구매 수량은 1개 이상이어야 합니다."
    }
}