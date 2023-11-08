package lotto.domain

import lotto.model.Lotto
import lotto.model.LottoBank
import lotto.model.LottoRanking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LottoBankTest {
    @Test
    fun `수익률을 올바르게 계산한다`() {
        val lottoBank = LottoBank()
        val purchaseLottoCount = 10
        LottoRanking.FIFTH_RANK.userLottoRankCnt ++
        val rateOfReturn = lottoBank.getRateOfReturn(purchaseLottoCount)
        val result = 50.0
        Assertions.assertEquals(rateOfReturn, result)
    }
}