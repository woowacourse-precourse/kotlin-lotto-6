package util

import camp.nextstep.edu.missionutils.Randoms
import model.Lotto

object LottoStore {
    fun generateLottoTickets(): Lotto {
        val pickNumbers = Randoms.pickUniqueNumbersInRange(LottoConfiguration.MIN_NUMBER.value, LottoConfiguration.MAX_NUMBER.value, LottoConfiguration.NUMBER_COUNT.value)
        return Lotto(pickNumbers)
    }
}
