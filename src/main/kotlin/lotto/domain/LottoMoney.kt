package lotto.domain

import lotto.util.LottoStore
import lotto.util.parseInt
import lotto.util.validateMultipleOf
import lotto.util.validatePositive

class LottoMoney private constructor(val money: Int) {
    companion object {
        fun from(inputMoney: String): LottoMoney {
            return LottoMoney(inputMoney
                    .parseInt()
                    .validatePositive()
                    .validateMultipleOf(LottoStore.LOTTO_TICKET_PRICE))
        }
    }
}