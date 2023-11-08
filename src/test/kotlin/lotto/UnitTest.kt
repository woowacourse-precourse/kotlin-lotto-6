package lotto

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class UnitTest {
    @Test
    fun `로또 검사기가 올바르게 동작하는지 확인`() {
        val winningNumbers = listOf(1,2,3,4,5,6)
        val lotto1 = Lotto(listOf(2,3,4,5,6,7))
        val bonusNumber = 1

        val output = LottoInspector().checkLotto(lotto1,winningNumbers,bonusNumber)
        assertThat(output == LottoAward.SECOND.reward)
    }

    @Test
    fun `수익률 계산이 맞는지 확인`() {
        val lottoResultList = arrayOf(0,0,0,0,0,1)
        val issuedLotto = LottoMaker().issueLotto(8000)
        val expectEarnedRate = 62.5
        val calculatedEarnedRate = LottoInspector().getEarningRate(lottoResultList,issuedLotto)
        assertThat(expectEarnedRate == LottoInspector().earningRateToPercent(calculatedEarnedRate))
    }
}