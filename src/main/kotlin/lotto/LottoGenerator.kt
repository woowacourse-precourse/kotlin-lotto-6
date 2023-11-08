package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoGenerator {
    companion object {
        fun generateLottoTicket(): Lotto {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
            return Lotto(numbers)
        }
    }
}