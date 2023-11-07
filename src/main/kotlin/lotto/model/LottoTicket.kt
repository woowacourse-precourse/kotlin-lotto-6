package lotto.model

import camp.nextstep.edu.missionutils.Randoms
import lotto.util.Constants.LOTTO_MAX_NUMBER
import lotto.util.Constants.LOTTO_MIN_NUMBER
import lotto.util.Constants.LOTTO_SIZE

class LottoTicket {
    private var _numbers: MutableList<List<Int>> = mutableListOf()
    val numbers: List<List<Int>>
        get() = _numbers

    fun lottoTicketPublish(purchaseCount: Int) {
        repeat(purchaseCount) {
            val publishTicket = publishOneTicket()
            addNumbers(publishTicket)
        }
    }

    private fun publishOneTicket(): List<Int> = Randoms.pickUniqueNumbersInRange(
        LOTTO_MIN_NUMBER,
        LOTTO_MAX_NUMBER,
        LOTTO_SIZE
    ).sorted()

    private fun addNumbers(lottoNumbers: List<Int>) = _numbers.add(lottoNumbers)
}