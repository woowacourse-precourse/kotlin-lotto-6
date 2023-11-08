package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.GameConstants.LOTTO_SIZE
import lotto.util.GameConstants.MAX_NUMBER
import lotto.util.GameConstants.MIN_NUMBER

class Ticket {
    private var _tickets: MutableList<List<Int>> = mutableListOf()

    val numbers: List<List<Int>>
        get() = _tickets

    private fun issueOneTicket(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, LOTTO_SIZE).sorted()
    }

    private fun addTicket(ticket: List<Int>) {
        _tickets.add(ticket)
    }

    fun issueLotto(count: Int) {
        repeat(count) {
            val ticket = issueOneTicket()
            addTicket(ticket)
        }
    }
}