package lotto.store.clerk

import java.math.BigDecimal

interface LottoClerk {
    // 돈을 받고 몇 회를 수행할 지 return
    fun publishLottoCount(money: BigDecimal): Int

    // 로또 결과를 손님에게 말해준다
    fun tellTheResultToCustomer(benefit: Float)
}