package util

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto

object LottoStore {
    fun generateLottoTickets(): Lotto {
        val pickNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
        return Lotto(pickNumbers)
    }
}
