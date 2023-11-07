package lotto.store.clerk

import java.math.BigDecimal

class KoreanLottoClerk : LottoClerk {
    override fun publishLottoCount(money: BigDecimal): Int {
        val count = (money / LOTTO_PRICE).toInt()
        println("$count" + "개를 구매했습니다.")
        return count
    }

    override fun tellTheResultToCustomer(benefit: Float) {
        print(String.format("총 수익률은 %.1f", benefit))
        println("%입니다.")
    }

    companion object {
        // 한국 로또 가격
        val LOTTO_PRICE: BigDecimal = BigDecimal.valueOf(1000L)
    }
}