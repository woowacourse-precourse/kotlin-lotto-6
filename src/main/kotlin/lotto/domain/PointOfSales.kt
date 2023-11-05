package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.data.Lotto

class PointOfSales {

    fun issueLotto(quantity: Int): List<Lotto> {
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

    private fun getRandomLottoNum() =
        Randoms.pickUniqueNumbersInRange(Lotto.START_NUM, Lotto.END_NUM, Lotto.LENGTH_OF_NUM).sorted()

}